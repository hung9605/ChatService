package com.app.service;

import java.util.List;

import com.app.dto.MessageDto;
import com.app.model.ChatMessage;

public interface ChatService{
	
	List<MessageDto> getMessageByUser(Integer page,String toAccount,String username);
	
	ChatMessage add(MessageDto message);

}