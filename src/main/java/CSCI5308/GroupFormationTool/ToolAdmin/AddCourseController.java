package CSCI5308.GroupFormationTool.ToolAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import CSCI5308.GroupFormationTool.Course.Course;
import CSCI5308.GroupFormationTool.Course.CourseFactory;
import CSCI5308.GroupFormationTool.Course.CourseObjectFactory;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.IAddCourseService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ToolAdminServiceFactory;

@Controller
public class AddCourseController {

	IAddCourseService addCourseService;

	public AddCourseController() {
		this.addCourseService = ToolAdminServiceFactory.instance().addCourseService();
	}

	@GetMapping("admin/add-course")
	public String addCourse(Model model) {
		model.addAttribute("course", CourseFactory.courseObject(new CourseObjectFactory()));
		model.addAttribute("resultMessage", "");
		return "admin/add-course";
	}

	@PostMapping("admin/add-new-course")
	public String addNewCourse(Course course, Model model) {
		String courseAddResult = addCourseService.addNewCourse(course);
		model.addAttribute("course", CourseFactory.courseObject(new CourseObjectFactory()));
		model.addAttribute("resultMessage", courseAddResult);

		return "admin/add-course";
	}

}
