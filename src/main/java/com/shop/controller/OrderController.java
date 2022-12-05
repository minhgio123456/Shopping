package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	
	
	@RequestMapping("/order/list")
	public String orderList() {
		
		return "order/order";
	}
	
	@RequestMapping("/order/detail/{id}")
	public String orderDetails() {
		
		return "order/details";
	}
}
