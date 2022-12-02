package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.User;

public interface UserDAO extends JpaRepository<User, Integer>{

}
