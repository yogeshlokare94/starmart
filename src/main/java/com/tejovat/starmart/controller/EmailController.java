package com.tejovat.starmart.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.starmart.service.EmailsService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	EmailsService emailsService;
	
	@GetMapping("/test")
	public ResponseEntity<Map<String, String>> sendSimpleMail(@RequestParam String toEmail) {
		Map<String,String> map = new HashMap<>();
		emailsService.sendSimpleMessageEmail(toEmail, "Test Email From Starmart", "This is Test Email, Pls Ignore");
		map.put("Message", "Sent Email successfully To: "+toEmail);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/testhtml")
	public ResponseEntity<Map<String, String>> sendTestHtmlMail(@RequestParam String toEmail) throws MessagingException {
		Map<String,String> map = new HashMap<>();
		emailsService.sendHtmlEmail(toEmail);
		map.put("Message", "Sent HTML Email successfully To: "+toEmail);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
