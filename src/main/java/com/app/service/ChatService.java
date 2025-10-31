package com.app.service;

import java.util.List;

import com.app.dto.MessageDto;

public interface ChatService{
	
	List<MessageDto> getMessageByUser(String username);

}