package CSCI5308.GroupFormationTool.Profile;

import CSCI5308.GroupFormationTool.Profile.Service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView userLogin(@ModelAttribute User user, Model model, RedirectAttributes rattrs) {
		LoginService loginService = new LoginServiceImpl();
		String initialPage = loginService.checkAccessService(user, model);
		if (initialPage == "login") {
			model.addAttribute("error", "Invalid Credentials");
			return new ModelAndView(initialPage);
		} else {
			return new ModelAndView(initialPage);
		}

	}

	@GetMapping("/logout")
	public String logoutUser() {
		return "profile/logout";
	}
}
