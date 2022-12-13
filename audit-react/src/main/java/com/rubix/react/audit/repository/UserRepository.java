package com.rubix.react.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.react.audit.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String pass);

	User findByUserId(long id);

}
