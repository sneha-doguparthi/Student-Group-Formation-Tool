package CSCI5308.GroupFormationTool.Course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

@Controller
public class CourseAdminController {

	@PostMapping("/course/course-admin-home")
	public String courseAdminHomePageRequest(@RequestParam String courseId, @RequestParam String courseCode,
			@RequestParam String courseName, @RequestParam String courseRole, Model model) {

		model.addAttribute("courseId", courseId);
		model.addAttribute("courseName", courseName);
		model.addAttribute("courseCode", courseCode);

		if (Integer.parseInt(courseRole) == (ApplicationConstants.INSTRUCTOR_ROLE_ID)) {
			model.addAttribute("displayQuestionManager", true);
		} else {
			model.addAttribute("displayQuestionManager", false);
		}

		return "course/course-admin-home";
	}

	@PostMapping("/course/course-admin-actions")
	public String courseAdminActionsPageRequest(@RequestParam String courseId, @RequestParam String courseCode,
			@RequestParam String courseName, Model model) {

		model.addAttribute("courseId", courseId);
		model.addAttribute("courseName", courseName);
		model.addAttribute("courseCode", courseCode);

		return "course/course-admin-actions";
	}

}
