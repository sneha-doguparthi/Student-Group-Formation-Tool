package CSCI5308.GroupFormationTool.Course;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Course.Service.CourseServiceFactory;
import CSCI5308.GroupFormationTool.Course.Service.IAssignTaService;
import CSCI5308.GroupFormationTool.Profile.IUser;

@Controller
public class AssignTaController {

	IAssignTaService assignTaService;

	public AssignTaController() {
		this.assignTaService = CourseServiceFactory.instance().assignTaService();
	}

	@PostMapping("/course-admin/assign-ta")
	public String searchTa(@RequestParam String courseId, @RequestParam String courseCode,
			@RequestParam String courseName, Model model) {

		ArrayList<IUser> users = assignTaService.getAllUsers();

		model.addAttribute("users", users);
		model.addAttribute("courseId", courseId);
		model.addAttribute("courseCode", courseCode);
		model.addAttribute("courseName", courseName);

		return "course/assign-ta";
	}

	@PostMapping("/course/do-assign-ta")
	public String assignTa(@RequestParam String courseId, @RequestParam String courseCode,
			@RequestParam String courseName, @RequestParam String userId, Model model) {

		assignTaService.assignTa(userId, Integer.valueOf(courseId));

		model.addAttribute("courseId", courseId);
		model.addAttribute("courseCode", courseCode);
		model.addAttribute("courseName", courseName);

		return "course/assign-ta-success";
	}
}
