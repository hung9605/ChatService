package com.app.service.serviceimpl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.dto.MessageDto;
import com.app.mapper.MessageMapper;
import com.app.model.ChatMessage;
import com.app.repository.ChatRepository;
import com.app.service.ChatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	final ChatRepository chatRepository;
	final MessageMapper messageMapper;

	@Override
	public List<MessageDto> getMessageByUser(Integer page,String toAccount,String username) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, 25);
		return messageMapper.maptoDtos(chatRepository.findMessagesBetweenUsers(toAccount,username,pageable));
	}

	@Override
	public ChatMessage add(MessageDto message) {
		// TODO Auto-generated method stub
		return  chatRepository.save(messageMapper.maptoModel(message));
	}

}
