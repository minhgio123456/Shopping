package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String>{

}
