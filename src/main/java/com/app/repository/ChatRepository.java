package com.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.ChatMessage;

public interface ChatRepository extends JpaRepository<ChatMessage, Integer> {
	
	List<ChatMessage> findTop5ByUsernameOrderByCreatedAtDesc(String username);
	List<ChatMessage> findTop10ByToAccountAndUsernameOrderByCreatedAtDesc(String toAccount,String username);
	
	
	@Query("""
		    SELECT m FROM ChatMessage m
		    WHERE (m.username = :userA AND m.toAccount = :userB)
		       OR (m.username = :userB AND m.toAccount = :userA)
		    ORDER BY m.createdAt DESC
		""")
		List<ChatMessage> findMessagesBetweenUsers(@Param("userA") String userA,
		                                       @Param("userB") String userB,
		                                       Pageable pageable);



}