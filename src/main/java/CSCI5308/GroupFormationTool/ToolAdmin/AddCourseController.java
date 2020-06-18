package CSCI5308.GroupFormationTool.ToolAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AddCourseService;

@Controller
public class AddCourseController {

	AddCourseService addCourseService;

	public AddCourseController() {
		this.addCourseService = SystemConfig.instance().getAddCourseService();
	}

	@GetMapping("admin/add-course")
	public String addCourse(Model model) {

		model.addAttribute("course", new Course());
		model.addAttribute("resultMessage", "");

		return "admin/add-course";
	}

	@PostMapping("admin/add-new-course")
	public String addNewCourse(Course course, Model model) {

		String courseAddResult = addCourseService.addNewCourse(course);

		model.addAttribute("course", new Course());
		model.addAttribute("resultMessage", courseAddResult);

		return "admin/add-course";
	}

}
