package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.RoleDAO;
import com.shop.entity.Role;
import com.shop.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService{
	@Autowired
	private RoleDAO dao;
	
	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}
}
