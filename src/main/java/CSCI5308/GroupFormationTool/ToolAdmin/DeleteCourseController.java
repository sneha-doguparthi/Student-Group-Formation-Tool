package CSCI5308.GroupFormationTool.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.IDeleteCourseService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.IViewCoursesService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ToolAdminServiceFactory;

@Controller
public class DeleteCourseController {

	IViewCoursesService viewCourseService;
	IDeleteCourseService deleteCourseService;

	public DeleteCourseController() {
		viewCourseService = ToolAdminServiceFactory.instance().viewCourseService();
		deleteCourseService = ToolAdminServiceFactory.instance().deleteCourseService();
	}

	@GetMapping("admin/delete-course")
	public String getAdminView(Model model) {

		ArrayList<ICourse> courseList = viewCourseService.getCourseList();

		model.addAttribute("courseList", courseList);
		model.addAttribute("deleteResultList", new ArrayList<>());

		return "admin/delete-course";
	}

	@PostMapping("admin/delete-course-request")
	public String deleteCourseFromList(@RequestParam("course-checkbox") ArrayList<String> deleteCourseList,
			Model model) {

		if (null != deleteCourseList) {
			ArrayList<String> deleteResultList = deleteCourseService.deleteCourse(deleteCourseList);
			model.addAttribute("deleteResultList", deleteResultList);
			model.addAttribute("courseList", new ArrayList<>());
		}

		return "admin/delete-course";
	}

}