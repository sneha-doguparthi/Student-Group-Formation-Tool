package CSCI5308.GroupFormationTool.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.DeleteCourseService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ViewCoursesService;

@Controller
public class DeleteCourseController {

	ViewCoursesService viewCourseService;
	DeleteCourseService deleteCourseService;

	public DeleteCourseController() {
		viewCourseService = SystemConfig.instance().getViewCoursesService();
		deleteCourseService = SystemConfig.instance().getDeleteCourseService();
	}

	@GetMapping("admin/delete-course")
	public String getAdminView(Model model) {

		ArrayList<Course> courseList = viewCourseService.getCourseList();

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