package com.app.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.app.dto.UserDto;
import com.app.model.User;
@Mapper(componentModel = "spring")
public interface UserMapper {
	
	@Mapping(source = "status", target = "enabled")
	User mapToModel(UserDto dto);
	@Mapping(source = "enabled", target = "status")
	@Mapping(target = "roles", ignore = true)
	UserDto maptoDto(User model);	
	List<User> mapToModels(List<UserDto> dtos);
	List<UserDto> mapToDtos(List<User> users);
}