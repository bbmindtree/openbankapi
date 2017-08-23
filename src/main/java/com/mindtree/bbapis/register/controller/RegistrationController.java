package com.mindtree.bbapis.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bbapis.entity.Customer;
import com.mindtree.bbapis.register.service.RegistrationService;
import com.mindtree.bbapis.response.GenericResponse;

@RestController
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public GenericResponse register(@RequestBody Customer customer) {
		Customer newCustomer = registrationService.createCustomer(customer);
		String customerId = newCustomer.getMobile();
		return new GenericResponse(Boolean.TRUE, String.valueOf(customerId));
	}

	@RequestMapping(value = "resetPassword/request", method = RequestMethod.GET)
	public GenericResponse changePasswordRequest(@RequestParam(value = "userId") String userId) {
		return new GenericResponse(registrationService.sendPasswordChangeLink(userId));
	}

	@RequestMapping(value = "resetPassword/update", method = RequestMethod.PUT)
	public GenericResponse updatePassword(@RequestBody Customer customer) {
		return new GenericResponse(registrationService.updatePassword(customer));
	}

}
