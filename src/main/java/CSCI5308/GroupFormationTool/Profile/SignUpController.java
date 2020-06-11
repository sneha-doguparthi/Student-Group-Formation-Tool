package CSCI5308.GroupFormationTool.Profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.Service.RegistrationService;
import CSCI5308.GroupFormationTool.Profile.Service.RegistrationServiceImpl;

@Controller
public class SignUpController {

	@GetMapping("/signup")
	public String getSignup(Model model) {
		model.addAttribute("user", new User());
		return "profile/signup";
	}

	@PostMapping("/signup")
	public String registerUser(@ModelAttribute User user, Model model) {
		RegistrationService registrationService = new RegistrationServiceImpl();

		boolean success = registrationService.registerUserService(user);

		if (success) {
			model.addAttribute("success", "Sign up succesful, Click on Login");
			return "profile/signup";
		} else {
			return "profile/existing-user";
		}
	}
}
