package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmailRequest;
import com.app.service.EmailService;

import jakarta.mail.MessagingException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") 
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailController extends BaseController {
	
	  final EmailService emailService;

	  @PostMapping("/send")
	  public ResponseEntity<?> sendMail(@RequestBody EmailRequest request) throws MessagingException {
	            emailService.sendHtmlMail(request);
	            return defaultResponse();
	  }
}