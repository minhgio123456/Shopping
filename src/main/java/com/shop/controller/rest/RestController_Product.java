package com.shop.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Product;
import com.shop.service.ProductsService;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/product")
public class RestController_Product {
	
	@Autowired
	private ProductsService dao;
	
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return dao.findById(id);
	}
	
	@GetMapping()
	public List<Product> getAll(@RequestParam("cid") Optional<Integer> cid) {
		if(cid.isPresent()) {
			List<Product> list = dao.findByProbrandId(cid.get());
			return list;
		} else {
			List<Product> list = dao.findAll();
			return list;
		}
	}
	
	
}
