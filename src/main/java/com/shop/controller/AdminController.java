package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/order")
	public String product() {
		return "order/order";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/indexView";
	}
	
	@RequestMapping("/adminVoucher")
	public String adminUser() {
		return "adminCRUD/voucher";
	}
	
	@RequestMapping("/adminRole")
	public String adminRole() {
		return "adminCRUD/role";
	}
	
	@RequestMapping("/adminProBrand")
	public String adminProBrand() {
		return "adminCRUD/productBrand";
	}
	
	@RequestMapping("/adminVoucherData")
	public String adminVouData() {
		return "adminCRUD/voucherData";
	}
}
