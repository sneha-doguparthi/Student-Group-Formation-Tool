package CSCI5308.GroupFormationTool.CourseAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseAdminController {

	@PostMapping("/course-admin")
	public String courseAdmin(@RequestParam String id, @RequestParam String code, @RequestParam String name,
			Model model) {

		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);

		return "course/course-admin";
	}

}
