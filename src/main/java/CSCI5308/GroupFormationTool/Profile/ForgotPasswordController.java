package CSCI5308.GroupFormationTool.Profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Model.PasswordPolicy;
import CSCI5308.GroupFormationTool.Profile.Service.IOtpService;
import CSCI5308.GroupFormationTool.Profile.Service.ProfileServiceFactory;

@Controller
public class ForgotPasswordController {

	IOtpService otpService;

	public ForgotPasswordController() {
		this.otpService = ProfileServiceFactory.instance().otpService();
	}

	@GetMapping("/profile/forgot")
	public String forgotPasswordHome() {
		return "profile/forgot-home";
	}

	@PostMapping("/profile/send-otp")
	public String sendOtp(@RequestParam String email, Model model) {

		String response = otpService.sendOtp(email);

		if (response != "user_not_found") {
			model.addAttribute("response", "user_found");
			model.addAttribute("email", email);
			model.addAttribute("policy", new PasswordPolicy());
		} else {
			model.addAttribute("response", response);
		}

		return "profile/forgot-send-otp";
	}

	@PostMapping("/profile/verify-otp")
	public String verifyOtp(@RequestParam String email, @RequestParam String otp, @RequestParam String password,
			Model model) {

		PasswordPolicy policy = new PasswordPolicy();

		if (!policy.validatePassword(email, password)) {
			model.addAttribute("response", "policy_violated");
			model.addAttribute("email", email);
			model.addAttribute("policy", policy);
			return "profile/forgot-send-otp";
		}

		String response = otpService.verifyOtp(email, otp, password);
		model.addAttribute("response", response);

		return "profile/verify-otp";
	}

}
