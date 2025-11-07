package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.UserChatDto;
import com.app.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

	@Query(value = """
			    		select u.username, m.message,
			(
			    select count(*)
			    from message m2
			    where (m2.to_account = u.username or m2.username = u.username)
			      and m2.status = false
			) as unreadCount
			 from users u left join message m
			on  m.id = (select max(id) from message m1 where  m1.to_account = u.username or u.username = m1.username)
			 where u.username not in (select username from authorities where authority = 'ROLE_ADMIN' );
			    		""", nativeQuery = true)
	public List<UserChatDto> lstUser();

}