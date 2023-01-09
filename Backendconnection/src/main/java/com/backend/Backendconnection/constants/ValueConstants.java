package com.backend.Backendconnection.constants;

public class ValueConstants {
	//DB collections
	  public static final String devices_collection = "Stream";
	  public static final String users_collection = "RegisterUsers";
	  public static final String shipment_collection = "Shipment"; 
	  
	  //exception
	  public static final String not_found = "not found"; 
	  
	  //password encrypt
	  public static final String passwordencrypt = "mypassword";
	  
	  //password validations
	  public static final String not_empty = "not empty";
	  public static final String password_length_error  = "Password should be less than 15 and more than 8 characters in length.";
	  public static final String upper_case_error  = "Password should contain atleast one upper case alphabet";
	  public static final String lower_case_error  = "Password should contain atleast one lower case alphabet";
	  public static final String number_error  = "Password should contain atleast one number.";
	  public static final String special_case_error = "Password should contain atleast one special character";
	  public static final String special_char = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
	  public static final String char_error = "Password should contain atleast one special character";
	  public static final String email_valid = "email is not valid";
	 
	  public static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	  
	 //shipment validation
	  public static final String shipment_number ="Enter Shipment Number!";
	    public static final String container_number ="Enter Container Number!";
	    public static final String description ="Provide a description!";
	    public static final String route ="Select a Route!";
	    public static final String goods ="Select Goods!";
	    public static final String device ="Select Device!";
	    public static final String date ="Enter Date!";
	    public static final String po_numnber ="Enter PO Number!";
	    public static final String delivery_number ="Enter Delivery Number!";
	    public static final String ndc_number ="Enter NDC Number!";
	    public static final String batch_id ="Enter Batch ID!";
	    public static final String serial_number ="Enter Serial Number!";
	    public static final String shipment_specialchar  = "Shipment number not allow any special character";
	    

}
