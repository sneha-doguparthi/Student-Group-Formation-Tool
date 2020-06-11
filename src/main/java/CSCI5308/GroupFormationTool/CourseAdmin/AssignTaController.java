package CSCI5308.GroupFormationTool.CourseAdmin;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.CourseAdmin.Service.AssignTaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import CSCI5308.GroupFormationTool.CourseAdmin.Service.AssignTaService;
import CSCI5308.GroupFormationTool.Model.User;

@Controller
public class AssignTaController {

	@PostMapping("/assign-ta")
	public String searchTa(@RequestParam String id, @RequestParam String code, @RequestParam String name, Model model) {

		AssignTaService assignTaService = new AssignTaServiceImpl();

		ArrayList<User> users = assignTaService.getAllUsers();
		model.addAttribute("users", users);

		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);

		return "course/assign-ta";
	}

	@PostMapping("/do-assign-ta")
	public String assignTa(@RequestParam String id, @RequestParam String code, @RequestParam String name,
			@RequestParam String userId, Model model) {

		AssignTaService assignTaService = new AssignTaServiceImpl();
		assignTaService.assignTa(userId, Integer.valueOf(id));

		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);

		return "course/assign-ta-success";
	}
}
