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

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatServiceImpl implements ChatService {
	
	final ChatRepository chatRepository;
	final MessageMapper messageMapper;

	@Override
	public List<MessageDto> getMessageByUser(Integer page,String toAccount,String username) {
		Pageable pageable = PageRequest.of(page, 50);
		return messageMapper.maptoDtos(chatRepository.findMessagesBetweenUsers(toAccount,username,pageable));
	}

	@Override
	public ChatMessage add(MessageDto message) {
		return  chatRepository.save(messageMapper.maptoModel(message));
	}

	@Override
	public int markMessagesAsRead(String from, String to) {
		// TODO Auto-generated method stub
		return chatRepository.markMessagesAsRead(from,to);
	}

}
