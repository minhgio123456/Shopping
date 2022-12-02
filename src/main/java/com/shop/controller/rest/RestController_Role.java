package com.shop.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Role;
import com.shop.service.RolesService;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/role")
public class RestController_Role {
	@Autowired
	private RolesService dao;
	
	@GetMapping
	public List<Role> getAll(){
		return  dao.findAll();
	}
}
