package com.backend.Backendconnection.validation;

import com.backend.Backendconnection.models.Shipment;
import static com.backend.Backendconnection.constants.ValueConstants.shipment_number;
import static com.backend.Backendconnection.constants.ValueConstants.container_number;
import static com.backend.Backendconnection.constants.ValueConstants.description;
import static com.backend.Backendconnection.constants.ValueConstants.route;
import static com.backend.Backendconnection.constants.ValueConstants.goods;
import static com.backend.Backendconnection.constants.ValueConstants.device;
import static com.backend.Backendconnection.constants.ValueConstants.date;
import static com.backend.Backendconnection.constants.ValueConstants.po_numnber;
import static com.backend.Backendconnection.constants.ValueConstants.delivery_number;
import static com.backend.Backendconnection.constants.ValueConstants.ndc_number;
import static com.backend.Backendconnection.constants.ValueConstants.batch_id;
import static com.backend.Backendconnection.constants.ValueConstants.serial_number;

public class ShipmentValidation {

	public static boolean validation1(Shipment shipment) throws Exception {

		if ((shipment.getShipmentNo()).length() == 0) {
			throw new Exception(shipment_number);
		} else if ((shipment.getContainerNo()).length() == 0) {
			throw new Exception(container_number);

		} else if ((shipment.getDescription()).length() == 0) {
			throw new Exception(description);

		} else if ((shipment.getRoute_details()).length() == 0) {
			throw new Exception(route);

		} else if ((shipment.getGoods_type()).length() == 0) {
			throw new Exception(goods);

		} else if ((shipment.getDevice()).length() == 0) {
			throw new Exception(device);

		} else if ((shipment.getEx_date_of_delivery()).length() == 0) {
			throw new Exception(date);

		} else if ((shipment.getPo_number()).length() == 0) {
			throw new Exception(po_numnber);

		}
		else if ((shipment.getDel_number()).length() == 0) {
			throw new Exception(delivery_number);

		}
		
		else if ((shipment.getNdc_number()).length() == 0) {
			throw new Exception(ndc_number);

		} else if ((shipment.getBatch_id()).length() == 0) {
			throw new Exception(batch_id);

		} else if ((shipment.getSerial_no_of_goods()).length() == 0) {
			throw new Exception(serial_number);

		}

		return true;

	}
}
