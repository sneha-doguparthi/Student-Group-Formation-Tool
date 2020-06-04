package com.asdc.group6.Profile.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.Login.Service.LoginService;

@Controller
public class LoginController {

	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@GetMapping("/login")
	public String getLogin(Model m) {
		m.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String userLogin(@ModelAttribute User user, Model model) {
	
		String initialPage = loginService.checkAccessService(user, model);
		
		if (initialPage == "login") {
			model.addAttribute("error", "User does not exists, Click on Register");
			return initialPage;
		} else
			return initialPage;
	}
	
	@PostMapping("/student-home")
	public String studentHome(@RequestParam String name, Model model) {
		
		model.addAttribute("name", name);
		return "student-home";
	}
}
