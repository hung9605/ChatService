package com.app.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.NotificationMessage;
import com.app.dto.ResponseBean;
import com.app.model.ChatMessage;
import com.app.service.ChatService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatController extends BaseController {

	   final SimpMessagingTemplate messagingTemplate;
	   final ChatService chatService;

	   //@MessageMapping("/notify")
	   @PostMapping("/notify")
	   public void sendNotification(@RequestBody ChatMessage chatMessage) {
	        String username = chatMessage.getUsername();
	        System.out.println("📩 Gửi notify tới user: " + username);

	        // gửi về client theo channel /user/queue/notify
	        messagingTemplate.convertAndSendToUser(
	            username,
	            "/queue/notify",
	            new NotificationMessage("tesssst", "tessst")
	        );
	    }
	   
	   @GetMapping("/getMessage")
	   public ResponseEntity<?> getMessage(Principal principal) {
	        return response(new ResponseBean(chatService.getMessageByUser(principal.getName())));
	   }
	
}
