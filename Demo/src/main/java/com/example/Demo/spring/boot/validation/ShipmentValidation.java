package com.example.Demo.spring.boot.validation;

import javax.validation.Valid;



import com.example.Demo.spring.boot.entities.Shipment;

public class ShipmentValidation {

	public static String validation1(@Valid Shipment shipment) {

		String message = "";
		  final String specialchar = "^[a-zA-Z0-9.,/ $@()]+$";
		  
		 
		
		if (shipment.getShipmentNo().length() == 0) {
			message = "Enter Shipment number";
		} 
		else if (!shipment.getShipmentNo().matches(specialchar)) {
			message = "Shipment number not allow any special characters";
		  
		}else if (shipment.getContainerNo().length() == 0) {
			message = "Enter Container number";
		}
		else if (shipment.getDescription().length() == 0) {
			message = "Enter Shipment Description";
		}
		else if (!shipment.getDescription().matches(specialchar)) {
			message = "Shipment description not allow any special characters";
		  
		}else if (shipment.getRoute_details().length() == 0) {
			message = "select Route type";
		} else if (shipment.getGoods_type().length() == 0) {
			message = "select Goods type";
		} else if (shipment.getDevice().length() == 0) {
			message = "Enter Device name";
		} else if (shipment.getEx_date_of_delivery().length() == 0) {
			message = "select Expected date of delivery";
		} else if (shipment.getPo_number().length() == 0) {
			message = "PO number should not be null";
		} else if (shipment.getNdc_number().length() == 0) {
			message = "NDC number should not be null";
		} else if (shipment.getBatch_id().length() == 0) {
			message = "Enter Batch Id";
		} else if (shipment.getSerial_no_of_goods().length() == 0) {
			message = "Enter Serial number of goods";
		}

		return message;

	}
}
