package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.ChatMessage;

public interface ChatRepository extends JpaRepository<ChatMessage, Integer> {
	
	
	List<ChatMessage> findTop5ByUsernameOrderByCreatedAtDesc(String username);

}