package CSCI5308.GroupFormationTool.Profile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CSCI5308.GroupFormationTool.Profile.Service.ILoginService;
import CSCI5308.GroupFormationTool.Profile.Service.ProfileServiceFactory;

@Controller
public class LoginController {

	private Logger logger = LogManager.getLogger(LoginController.class);
	ILoginService loginService;

	public LoginController() {
		this.loginService = ProfileServiceFactory.instance().loginService();
	}

	@RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET })
	public String basePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String email = authentication.getName();
			String nextPage = loginService.checkAccessService(email, model);
			return nextPage;
		}
		return "profile/login";
	}

	@GetMapping("/profile/login")
	public String getLogin() {
		logger.info("Application login page requested.");
		return "profile/login";
	}

}
