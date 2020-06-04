package com.asdc.group6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotPasswordController {

	@GetMapping("/forgot")
	public String forgotPasswordHome() {
		return "forgot-home";
	}
}
