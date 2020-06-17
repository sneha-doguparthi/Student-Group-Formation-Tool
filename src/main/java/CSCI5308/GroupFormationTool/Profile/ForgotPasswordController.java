package CSCI5308.GroupFormationTool.Profile;

import CSCI5308.GroupFormationTool.Model.PasswordPolicy;
import CSCI5308.GroupFormationTool.Profile.Service.OtpServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Profile.Service.OtpService;

@Controller
public class ForgotPasswordController {

	@GetMapping("/profile/forgot")
	public String forgotPasswordHome() {
		return "profile/forgot-home";
	}

	@PostMapping("/profile/send-otp")
	public String sendOtp(@RequestParam String email, Model model) {

		OtpService otpService = new OtpServiceImpl();

		// send otp to email provided by user
		String response = otpService.sendOtp(email);

		if (response != "user_not_found") {
			// if provided email match database record then forward user to next page
			model.addAttribute("response", "user_found");
			// also passing email to next page to match email and otp on further stages
			model.addAttribute("email", email);
			// passing on-going password policy details
			model.addAttribute("policy", new PasswordPolicy());
		} else {
			// if provided email does not match database record then display error
			// here the value of response would be "user_not_found"
			model.addAttribute("response", response);
		}

		return "profile/forgot-send-otp";
	}

	@PostMapping("/profile/verify-otp")
	public String verifyOtp(@RequestParam String email, @RequestParam String otp, @RequestParam String password,
			Model model) {

		PasswordPolicy policy = new PasswordPolicy();
		if(!policy.validatePassword(email, password)){
			// ask for password another time if policy is violated
			model.addAttribute("response", "policy_violated");
			model.addAttribute("email", email);
			model.addAttribute("policy", policy);

			return "profile/forgot-send-otp";
		}

		OtpService otpService = new OtpServiceImpl();

		// verify otp provided by user attached to their email
		String response = otpService.verifyOtp(email, otp, password);
		model.addAttribute("response", response);

		return "profile/verify-otp";
	}
}
