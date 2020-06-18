package CSCI5308.GroupFormationTool.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping("/error")
	public String showError(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			int statusCode = Integer.parseInt(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				model.addAttribute("errorCode", 404);
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				model.addAttribute("errorCode", 500);
			} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				model.addAttribute("errorCode", 403);
			} else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
				model.addAttribute("errorCode", 405);
			} else {
				model.addAttribute("errorCode", statusCode);
			}
		}

		return "error/error";
	}

	@Override
	public String getErrorPath() {
		return "/error/error";
	}
}
