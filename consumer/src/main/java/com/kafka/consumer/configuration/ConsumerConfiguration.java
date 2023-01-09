package com.kafka.consumer.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.bson.Document;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.time.Duration;
import java.util.Arrays;

import java.util.Properties;

@Component
public class ConsumerConfiguration {
	private static MongoCollection<Document> coll = null;
	static String uri = "mongodb+srv://Sangeetha:ViFw2ZYk51e4Huzq@cluster0.th72q5f.mongodb.net/?retryWrites=true&w=majority";
	
	
	public void consume() throws JSONException {
		try {

			MongoClient mongoClient = MongoClients.create(uri);
			MongoDatabase db = mongoClient.getDatabase("SCMExpert");

			coll = db.getCollection("Stream");
			System.out.println("Mongo connection estabished  ......");

		}

		catch (Exception e) {
			// handle server down or failed query here.
		}
		Logger logger = LoggerFactory.getLogger(ConsumerConfiguration.class.getName());
		
	String bootstrapServers = "127.0.0.1:9092";
	//	String bootstrapServers = "kafka:9092";
		String grp_id = "group-id";
		String topic = "Topic1";

		// Creating consumer properties
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, grp_id);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		// creating consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

		// Subscribing
		consumer.subscribe(Arrays.asList(topic));
		// polling
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			for (ConsumerRecord<String, String> record : records) {

				logger.info("Key: " + record.key() + ", Value:" + record.value());
				logger.info("Partition:" + record.partition() + ",Offset:" + record.offset());
				Document doc = Document.parse(record.value());
				coll.insertOne(doc);

			}

		}

	}

}
