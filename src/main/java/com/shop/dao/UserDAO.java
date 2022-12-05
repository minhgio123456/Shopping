package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Users;

public interface UserDAO extends JpaRepository<Users, Integer>{
	
	@Query(value = "SELECT * FROM [User] WHERE User_username = ?1",nativeQuery = true)
	Users findByUserID(String id);
}
