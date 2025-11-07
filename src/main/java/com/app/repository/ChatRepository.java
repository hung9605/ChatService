package com.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.ChatMessage;

public interface ChatRepository extends JpaRepository<ChatMessage, Integer> {
	
	List<ChatMessage> findTop5ByUsernameOrderByCreatedAtDesc(String username);
	List<ChatMessage> findTop10ByToAccountAndUsernameOrderByCreatedAtDesc(String toAccount,String username);
	
	
	@Query("""
		    SELECT m FROM ChatMessage m
		    WHERE (m.username = :userA AND m.toAccount = :userB)
		       OR (m.username = :userB AND m.toAccount = :userA)
		    ORDER BY m.createdAt desc 
		""")
		List<ChatMessage> findMessagesBetweenUsers(@Param("userA") String userA,
		                                       @Param("userB") String userB,
		                                       Pageable pageable);
	
	@Modifying
    @Transactional
    @Query("UPDATE ChatMessage m SET m.status = true " +
           "WHERE (m.username = :username OR m.toAccount = :toAccount) AND m.status = false")
    int markMessagesAsRead(
    					   @Param("username") String username,
                           @Param("toAccount") String toAccount);



}