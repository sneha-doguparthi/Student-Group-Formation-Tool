package CSCI5308.GroupFormationTool.Profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.PasswordPolicy;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.Service.RegistrationService;

@Controller
public class SignUpController {

	RegistrationService registrationService;

	public SignUpController() {
		this.registrationService = SystemConfig.instance().getRegistrationService();
	}

	@GetMapping("/profile/signup")
	public String getSignup(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("policy", new PasswordPolicy());

		return "profile/signup";
	}

	@PostMapping("/profile/signup")
	public String registerUser(@ModelAttribute User user, Model model) {

		PasswordPolicy policy = new PasswordPolicy();

		if (!policy.validatePassword(user.getEmail(), user.getPassword())) {
			model.addAttribute("user", new User());
			model.addAttribute("policy", policy);
			model.addAttribute("error", "Your new password does not satisfy password policy.");

			return "profile/signup";
		}

		boolean success = registrationService.registerUserService(user);

		if (success) {
			model.addAttribute("success", "Sign up successful");
			return "profile/signup";
		} else {
			return "profile/existing-user";
		}
	}

}
