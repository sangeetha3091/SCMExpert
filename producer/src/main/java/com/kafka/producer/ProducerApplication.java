package com.kafka.producer;

import org.json.JSONException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.producer.configurations.ProducerConfiguration;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) throws JSONException {

		ProducerConfiguration producer = new ProducerConfiguration();

		producer.Client1("localhost", 12345);

	}
}