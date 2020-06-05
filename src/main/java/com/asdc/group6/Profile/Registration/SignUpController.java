package com.asdc.group6.Profile.Registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.Registration.Service.RegistrationService;
import com.asdc.group6.Profile.Registration.Service.RegistrationServiceImpl;

@Controller
public class SignUpController {

	@GetMapping("/signup")
	public String getSignup(Model m) {
		m.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/signup")
	public String registerUser(@ModelAttribute User user, Model model) {
		RegistrationService registrationService = new RegistrationServiceImpl();
		boolean success = registrationService.registerUserService(user);
		if (success) {
			model.addAttribute("success", "Sign up succesful, Click on Login");
			return "signup";
		} else {
			return "existing-user";
		}
	}
}
