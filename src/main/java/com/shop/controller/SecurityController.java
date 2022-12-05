package com.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("security")
public class SecurityController {
	
	@Autowired
	HttpServletRequest req;
	
	@GetMapping("login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập!");
		System.out.println(req.getRemoteUser());
		return "user/login";
	}
	
	@GetMapping("login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		System.out.println(req.getRemoteUser());
		return "user/login";
	}
	
	@GetMapping("login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập!");
		return "user/login";
	}
	
	@GetMapping("unauthorized")
	public String unauthorized(Model model) {
		model.addAttribute("message", "Không có quyền truy xuất!");
		return "user/login";
	}
	
	@GetMapping("logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Bạn đã đăng xuất!");
		return "user/login";
	}
}
