package com.example.Demo.spring.boot.entities;

public class Shipment {
	public Shipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shipment(String shipmentNo, String containerNo, String description, String route_details, String goods_type,
			String device, String ex_date_of_delivery, String po_number, String del_number, String ndc_number,
			String batch_id, String serial_no_of_goods) {
		super();
		this.shipmentNo = shipmentNo;
		this.containerNo = containerNo;
		this.description = description;
		this.route_details = route_details;
		this.goods_type = goods_type;
		this.device = device;
		this.ex_date_of_delivery = ex_date_of_delivery;
		this.po_number = po_number;
		this.del_number = del_number;
		this.ndc_number = ndc_number;
		this.batch_id = batch_id;
		this.serial_no_of_goods = serial_no_of_goods;
	}
	@Override
	public String toString() {
		return "Shipment [shipmentNo=" + shipmentNo + ", containerNo=" + containerNo + ", description=" + description
				+ ", route_details=" + route_details + ", goods_type=" + goods_type + ", device=" + device
				+ ", ex_date_of_delivery=" + ex_date_of_delivery + ", po_number=" + po_number + ", del_number="
				+ del_number + ", ndc_number=" + ndc_number + ", batch_id=" + batch_id + ", serial_no_of_goods="
				+ serial_no_of_goods + "]";
	}
	public String getShipmentNo() {
		return shipmentNo;
	}
	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}
	public String getContainerNo() {
		return containerNo;
	}
	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRoute_details() {
		return route_details;
	}
	public void setRoute_details(String route_details) {
		this.route_details = route_details;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getEx_date_of_delivery() {
		return ex_date_of_delivery;
	}
	public void setEx_date_of_delivery(String ex_date_of_delivery) {
		this.ex_date_of_delivery = ex_date_of_delivery;
	}
	public String getPo_number() {
		return po_number;
	}
	public void setPo_number(String po_number) {
		this.po_number = po_number;
	}
	public String getDel_number() {
		return del_number;
	}
	public void setDel_number(String del_number) {
		this.del_number = del_number;
	}
	public String getNdc_number() {
		return ndc_number;
	}
	public void setNdc_number(String ndc_number) {
		this.ndc_number = ndc_number;
	}
	public String getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}
	public String getSerial_no_of_goods() {
		return serial_no_of_goods;
	}
	public void setSerial_no_of_goods(String serial_no_of_goods) {
		this.serial_no_of_goods = serial_no_of_goods;
	}
	private String shipmentNo;
	private String containerNo;
	private String description;
	private String route_details;
	private String goods_type;
	private String device;
	private String ex_date_of_delivery;
	private String po_number;
	private String del_number;
	private String ndc_number;
	private String batch_id;
	private String serial_no_of_goods;
}
