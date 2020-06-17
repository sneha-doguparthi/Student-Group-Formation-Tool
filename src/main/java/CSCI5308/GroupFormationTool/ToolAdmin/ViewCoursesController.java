package CSCI5308.GroupFormationTool.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ViewCoursesService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ViewCoursesServiceImpl;

@Controller
public class ViewCoursesController {

	@GetMapping("admin/view-courses")
	public String getAdminView(Model model) {
		ViewCoursesService viewCourseService = new ViewCoursesServiceImpl();
		ArrayList<Course> courseList = viewCourseService.getCourseList();
		model.addAttribute("courseList", courseList);
		return "admin/view-courses";
	}
}