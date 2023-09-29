package com.order.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.app.model.Orders;
import com.order.app.model.UserProfile;
import com.order.app.repository.OrderRepository;


@Service
public class EmailService {

	
	@Autowired 
	private JavaMailSender javaMailSender;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	 @Value("${spring.mail.username}") 
	 private String sender;
	
	public boolean getEmail(String receiver,int OrderId) {
		
		Orders order = orderRepository.findById(OrderId).get();
		

		
		  UserProfile profile =
		  restTemplate.getForObject("http://localhost:8095/api/user/"+order.getUserId(),
		  UserProfile.class);
		 
		Integer a = order.getAddress().getHouseNumber();
		String address = a.toString()+", "
						+order.getAddress().getStreetName()+", "
						+order.getAddress().getColonyName()+", "
						+order.getAddress().getCity()+", "
						+order.getAddress().getState()+", "
						+order.getAddress().getPinCode().toString()+".";
		Integer totalItems = order.getItems().size();
		String message ="Dear, " 
							+ profile.getFullName() 
							+ "\n\n"
							+"Thank you for your order.\n"
							+ "We truly value our loyal customers. Thanks for making us who we are!\n\n"
							+ "Here’s order summary for your order: \n"
							+ "Order Id :" + order.getId()+"\n"
							+ "Order Date : "+ order.getOrderDate()+"\n"
							+ "Total Items : "+ totalItems.toString()+"\n"
							+ "amountPaid : "+ order.getAmountPaid() +"\n"
							+ "Payment Mode : " + order.getModeOfPayment() + "\n"
							+ "Address : " + address ;
		
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(receiver);
		mailMessage.setFrom(sender);
		mailMessage.setText(message);
        mailMessage.setSubject("Shop India : Order placed successfully");
        
        javaMailSender.send(mailMessage);
        return true;
	}
	
}



