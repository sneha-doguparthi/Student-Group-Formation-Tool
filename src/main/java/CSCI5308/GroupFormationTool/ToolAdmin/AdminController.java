package CSCI5308.GroupFormationTool.ToolAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("admin/admin-home")
	public String getAdminView() {
		return "admin/admin-home";
	}

}