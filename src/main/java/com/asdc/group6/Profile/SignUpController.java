package com.asdc.group6.Profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.asdc.group6.Models.User;

@Controller
public class SignUpController {

	@GetMapping("/signup")
	public String getSignup(Model m) {
		m.addAttribute("user", new User());
		return "signup";
	}	
	@PostMapping("/signup")
	public String registerUser(@ModelAttribute User user) {
		return "signup";	
	}
}

