package com.example.Demo.spring.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.example.Demo.spring.boot.entities.DeviceData;

import com.example.Demo.spring.boot.entities.Shipment;

import com.example.Demo.spring.boot.services.Shipmentservices;
import com.example.Demo.spring.boot.validation.ShipmentValidation;
@Controller
public class ShipmentController {

	@Autowired
	private Shipmentservices service;

	ResponseEntity<String> users;

	public ShipmentController(Shipmentservices service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/shipment", method = RequestMethod.GET)
	private ModelAndView getSignup(ModelAndView model) {
		System.out.print(model);
		model.addObject("shipment", new Shipment());
		model.setViewName("CreateShipment");
		return model;

	}

	@RequestMapping(value = "/shipment", method = RequestMethod.POST)
	public String postUsers(@ModelAttribute("shipment") @Valid Shipment user, BindingResult result) throws Exception {

//		users = service.saveUsers(user);
		String err = ShipmentValidation.validation1(user);
		if (!err.isEmpty()) {
			ObjectError error1 = new ObjectError("globalError", err);
			result.addError(error1);
		}
		if (result.hasErrors()) {
			return "CreateShipment";
		}
		service.saveUsers(user);
		return "redirect:/shipment?success";

	}


	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	public String home(Model model) {
		ResponseEntity<List<DeviceData>> listEmp = service.getData();

		List<DeviceData> s = listEmp.getBody();
		model.addAttribute("listEmp", s);

		return "DeviceDataStream";
	}

}
