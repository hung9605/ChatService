package com.app.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.mapper.UserMapper;
import com.app.repository.UserRepository;
import com.app.service.UserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	final UserRepository userRepository;
	final UserMapper userMapper;

	@Override
	public List<UserDto> list() {
		return userMapper.mapToDtos(userRepository.findAll());
	}

}
