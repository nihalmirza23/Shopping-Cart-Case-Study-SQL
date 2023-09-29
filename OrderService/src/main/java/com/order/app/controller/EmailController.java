package com.order.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.order.app.service.EmailService;

@RestController
public class EmailController {
	
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/email/{orderId}")
	public boolean sendEmail(@PathVariable("orderId") int orderId) {
		
		return emailService.getEmail("mirzanihal7717@gmail.com", orderId);
	}
	


}
