package com.mjh.exam.projoect1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHomeController {
	@RequestMapping("/usr/home/main")
	public String showMain() {
		return "usr/home/home";
	}
	
	@RequestMapping("/")
	public String returnMain() {
		return "redirect:/usr/home/main";
	}
	
	
}
