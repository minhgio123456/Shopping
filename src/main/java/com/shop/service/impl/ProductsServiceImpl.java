package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.ProductDAO;
import com.shop.entity.Product;
import com.shop.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	ProductDAO pdao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public List<Product> findTop6PageIndex() {
		// TODO Auto-generated method stub
		return pdao.findTop6();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByProbrandId(Integer id) {
		// TODO Auto-generated method stub
		return pdao.findByProbrandId(id);
	}
}
