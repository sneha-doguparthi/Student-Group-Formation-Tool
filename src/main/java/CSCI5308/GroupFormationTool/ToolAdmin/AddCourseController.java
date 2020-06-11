package CSCI5308.GroupFormationTool.ToolAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AddCourseService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AddCourseServiceImpl;

@Controller
public class AddCourseController {

	@GetMapping("/add-course")
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("resultMessage", "");
		return "admin/add-course";
	}

	@PostMapping("/add-new-course")
	public String addNewCourse(Course course, Model model) {
		AddCourseService addCourseService = new AddCourseServiceImpl();
		String courseAddResult = addCourseService.addNewCourse(course);
		model.addAttribute("course", new Course());
		model.addAttribute("resultMessage", courseAddResult);
		return "admin/add-course";
	}
}
