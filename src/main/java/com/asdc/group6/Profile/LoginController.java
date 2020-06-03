package com.asdc.group6.Profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String userLogin() {
		return "login";
	}
}
