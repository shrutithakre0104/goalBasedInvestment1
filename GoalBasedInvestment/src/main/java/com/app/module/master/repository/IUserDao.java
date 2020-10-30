package com.app.module.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

/**
 * @author shruti
 *
 */
public interface IUserDao extends JpaRepository<User, Long> {

	@Query("select user from User user where active=true")
	List<User> getAllActiveUsers();
}

