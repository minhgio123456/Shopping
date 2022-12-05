package com.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.UserDAO;
import com.shop.entity.Users;
import com.shop.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UserDAO udao;

	@Override
	public Users findById(String id) {
		// TODO Auto-generated method stub
		return udao.findByUserID(id);
	}

	

	
	
	
	
	
}
