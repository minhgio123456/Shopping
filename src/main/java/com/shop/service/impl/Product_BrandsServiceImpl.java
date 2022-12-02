package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.Product_BrandDAO;
import com.shop.entity.ProductBrand;
import com.shop.service.Product_BrandsService;

@Service
public class Product_BrandsServiceImpl implements Product_BrandsService{
	
	@Autowired
	Product_BrandDAO pdao;
	
	@Override
	public List<ProductBrand> findAll() {
		return pdao.findAll();
	}
	
}
