package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.service.Product_BrandsService;
import com.shop.service.ProductsService;

@Controller
public class IndexController {
	
	@Autowired
	Product_BrandsService proBrandService;
	
	@Autowired
	ProductsService proService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("listDM", proBrandService.findAll());
		model.addAttribute("listSP", proService.findTop6PageIndex());
		return "layout/indexView";
	}
}
