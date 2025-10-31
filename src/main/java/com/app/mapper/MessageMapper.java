package com.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.app.dto.MessageDto;
import com.app.model.ChatMessage;

@Mapper(componentModel = "spring")
public interface MessageMapper {
	
	MessageDto maptoDto(ChatMessage model);
	ChatMessage maptoModel(MessageDto dto);
	List<MessageDto> maptoDtos(List<ChatMessage> models);
	List<ChatMessage> maptoModels(List<MessageDto> dtos);
}
