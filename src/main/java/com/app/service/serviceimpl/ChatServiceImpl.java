package com.app.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.MessageDto;
import com.app.mapper.MessageMapper;
import com.app.repository.ChatRepository;
import com.app.service.ChatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	final ChatRepository chatRepository;
	final MessageMapper messageMapper;

	@Override
	public List<MessageDto> getMessageByUser(String username) {
		// TODO Auto-generated method stub
		return messageMapper.maptoDtos(chatRepository.findTop5ByUsernameOrderByCreatedAtDesc(username));
	}

}
