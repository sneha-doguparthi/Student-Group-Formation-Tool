package CSCI5308.GroupFormationTool.Profile;

import CSCI5308.GroupFormationTool.Profile.Service.LoginServiceImpl;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import CSCI5308.GroupFormationTool.Profile.Service.LoginService;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET })
	public String basePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String email = authentication.getName();
			LoginService loginService = new LoginServiceImpl();
			String nextPage = loginService.checkAccessService(email, model);
			return nextPage;
		}
		return "profile/login";
	}

	@GetMapping("/profile/login")
	public String getLogin() {
		return "profile/login";
	}
}
