package com.asdc.group6.ToolAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/adminHomeView")
	public String getAdminView() {
		return "AdminHome.html";
	}

}