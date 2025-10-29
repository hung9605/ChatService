package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.User;

public interface UserRepository extends JpaRepository<User,String> {
	
	Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

}