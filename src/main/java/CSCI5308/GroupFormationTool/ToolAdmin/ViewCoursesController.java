package CSCI5308.GroupFormationTool.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.IViewCoursesService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ToolAdminServiceFactory;

@Controller
public class ViewCoursesController {

	IViewCoursesService viewCourseService;

	public ViewCoursesController() {
		viewCourseService = ToolAdminServiceFactory.instance().viewCourseService();
	}

	@GetMapping("admin/view-courses")
	public String getAdminView(Model model) {

		ArrayList<ICourse> courseList = viewCourseService.getCourseList();

		model.addAttribute("courseList", courseList);

		return "admin/view-courses";
	}

}