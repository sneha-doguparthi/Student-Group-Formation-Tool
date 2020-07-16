package CSCI5308.GroupFormationTool.Profile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import CSCI5308.GroupFormationTool.Model.PasswordPolicy;
import CSCI5308.GroupFormationTool.Profile.Service.IRegistrationService;
import CSCI5308.GroupFormationTool.Profile.Service.ProfileServiceFactory;

@Controller
public class SignUpController {

	IRegistrationService registrationService;
	private Logger logger = LogManager.getLogger(LoginController.class);

	public SignUpController() {
		this.registrationService = ProfileServiceFactory.instance().registrationService();
	}

	@GetMapping("/profile/signup")
	public String getSignup(Model model) {
		model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
		model.addAttribute("policy", new PasswordPolicy());
		return "profile/signup";
	}

	@PostMapping("/profile/signup")
	public String registerUser(@ModelAttribute User user, Model model) {
		PasswordPolicy policy = new PasswordPolicy();
		if (!policy.validatePassword(user.getEmail(), user.getPassword())) {
			model.addAttribute("user", UserFactory.userObject(new UserObjectFactory()));
			model.addAttribute("policy", policy);
			model.addAttribute("error", "Your new password does not satisfy password policy.");
			logger.info("User password does not meet the policy criteria.");
			return "profile/signup";
		}
		logger.info("User password does not meet the policy criteria");
		boolean success = registrationService.registerUserService(user);
		if (success) {
			model.addAttribute("success", "Sign up successful");
			return "profile/signup";
		} else {
			return "profile/existing-user";
		}
	}

}
