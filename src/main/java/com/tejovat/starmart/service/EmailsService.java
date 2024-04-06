package com.tejovat.starmart.service;

import jakarta.mail.MessagingException;

public interface EmailsService {
	
	public void sendSimpleMessageEmail(String toEmail, String subject, String body);
	
	public void sendHtmlEmail(String toEmail) throws MessagingException ;

}
