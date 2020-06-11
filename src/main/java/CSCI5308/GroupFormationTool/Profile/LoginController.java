package CSCI5308.GroupFormationTool.Profile;

import CSCI5308.GroupFormationTool.Profile.Service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.Service.LoginService;

@Controller
public class LoginController {

	@GetMapping("/")
	public String basePage(Model model) {
		model.addAttribute("user", new User());
		return "profile/login";
	}

	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("user", new User());
		return "profile/login";
	}

	@PostMapping("/login")
	public String userLogin(@ModelAttribute User user, Model model) {

		LoginService loginService = new LoginServiceImpl();

		String initialPage = loginService.checkAccessService(user, model);

		if (initialPage == "login") {
			model.addAttribute("error", "Invalid Credentials");
			return initialPage;
		} else
			return initialPage;
	}

	@PostMapping("/student-home")
	public String studentHome(@RequestParam String name, Model model) {

		model.addAttribute("name", name);
		return "profile/student-home";
	}

	@GetMapping("/logout")
	public String logoutUser() {
		return "profile/logout";
	}
}
