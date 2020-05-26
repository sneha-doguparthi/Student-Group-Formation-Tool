package com.asdc.group6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	
	@GetMapping("/")
	public String basePage() {
		return "home.html";
	}
}
