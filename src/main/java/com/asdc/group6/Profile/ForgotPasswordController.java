package com.asdc.group6.Profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asdc.group6.Profile.Service.OtpService;

@Controller
public class ForgotPasswordController {
	private OtpService otpService;
	
	public ForgotPasswordController(OtpService otpService) {
		this.otpService = otpService;
	}

	@GetMapping("/forgot")
	public String forgotPasswordHome() {
		return "forgot-home";
	}
	
	@PostMapping("/send-otp")
	public String sendOtp(@RequestParam String email, Model model) {
		
		// send otp to email provided by user
		String response = otpService.sendOtp(email);
		
		
		if(response != "user_not_found") {
			// if provided email match database record then forward user to next page
			model.addAttribute("response", "user_found");
			// also passing email to next page to match email and otp on further stages
			model.addAttribute("email", email);
		} else {
			// if provided email does not match database record then display error
			// here the value of response would be "user_not_found"
			model.addAttribute("response", response);
		}
		
		return "forgot-send-otp";
	}
	
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam String email, @RequestParam String otp,
			@RequestParam String password, Model model) {
		
		// verify otp provided by user attached to their email
		String response = otpService.verifyOtp(email, otp, password);
		model.addAttribute("response",response);
		
		return "verify-otp";
	}
}
