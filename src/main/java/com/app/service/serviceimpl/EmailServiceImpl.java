package com.app.service.serviceimpl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.dto.EmailRequest;
import com.app.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailServiceImpl implements EmailService {
	
	final JavaMailSender mailSender;

	@Override
	public void sendHtmlMail(EmailRequest request) throws MessagingException {
		  	MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	        helper.setTo(request.getTo().split(","));
	        helper.setSubject(request.getSubject());
	        helper.setText(request.getContent(), true);
	        mailSender.send(message);
	}

}
