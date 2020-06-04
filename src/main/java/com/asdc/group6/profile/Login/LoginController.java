package com.asdc.group6.Profile.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.Login.Service.LoginService;
import com.asdc.group6.Profile.Login.Service.LoginServiceImpl;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getLogin(Model m) {
		m.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String userLogin(@ModelAttribute User user, Model model) {
		LoginService loginService = new LoginServiceImpl();
		String initialPage = loginService.checkAccessService(user);
		if (initialPage == "login") {
			model.addAttribute("error", "User does not exists, Click on Register");
			return initialPage;
		} else
			return initialPage;
	}
}
