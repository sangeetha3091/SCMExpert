package com.backend.Backendconnection.models;

import org.springframework.data.mongodb.core.mapping.Document;
import static com.backend.Backendconnection.constants.ValueConstants.devices_collection;

@Document(devices_collection)
public class DeviceData {

	private String _id;
	private String Battery_Level;
	private String Route_From;
	private String Device_Id;
	private String Route_To;
	private String First_Sensor_temperature;

	public DeviceData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceData(String _id, String battery_Level, String route_From, String device_Id, String route_To,
			String first_Sensor_temperature) {
		super();
		this._id = _id;
		Battery_Level = battery_Level;
		Route_From = route_From;
		Device_Id = device_Id;
		Route_To = route_To;
		First_Sensor_temperature = first_Sensor_temperature;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getBattery_Level() {
		return Battery_Level;
	}

	public void setBattery_Level(String battery_Level) {
		Battery_Level = battery_Level;
	}

	public String getRoute_From() {
		return Route_From;
	}

	public void setRoute_From(String route_From) {
		Route_From = route_From;
	}

	public String getDevice_Id() {
		return Device_Id;
	}

	public void setDevice_Id(String device_Id) {
		Device_Id = device_Id;
	}

	public String getRoute_To() {
		return Route_To;
	}

	public void setRoute_To(String route_To) {
		Route_To = route_To;
	}

	public String getFirst_Sensor_temperature() {
		return First_Sensor_temperature;
	}

	public void setFirst_Sensor_temperature(String first_Sensor_temperature) {
		First_Sensor_temperature = first_Sensor_temperature;
	}

}
