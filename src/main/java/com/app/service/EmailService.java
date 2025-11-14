package com.app.service;

import com.app.dto.EmailRequest;
import jakarta.mail.MessagingException;

public interface EmailService {
	
    public void sendHtmlMail(EmailRequest request) throws MessagingException;
}