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
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") 
public class MailController extends BaseController {
	
	  private final EmailService emailService;

	  @PostMapping("/send")
	  public ResponseEntity<?> sendMail(@RequestBody EmailRequest request) throws MessagingException {
	            emailService.sendHtmlMail(request);
	            return defaultResponse();
	  }
}