package CSCI5308.GroupFormationTool.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AssignInstructorService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.AssignInstructorServiceImpl;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ViewCoursesService;
import CSCI5308.GroupFormationTool.ToolAdmin.Service.ViewCoursesServiceImpl;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

@Controller
public class AssignInstructorController {

	ArrayList<Course> courseList;
	ArrayList<User> userList;

	@GetMapping("admin/assign-instructor")
	public String getAdminView(Model model) {
		ViewCoursesService viewCourseService = new ViewCoursesServiceImpl();
		courseList = viewCourseService.getCourseList();
		model.addAttribute("courseList", courseList);
		AssignInstructorService assignInstructorService = new AssignInstructorServiceImpl();
		userList = assignInstructorService.getUserList();
		model.addAttribute("userList", userList);
		model.addAttribute("resultMessage", "");
		return "admin/assign-instructor";
	}

	@PostMapping("admin/assign-role")
	public String assignRole(@RequestParam("CourseCode") String courseCode, User user, Model model) {
		model.addAttribute("courseList", courseList);
		model.addAttribute("userList", userList);
		model.addAttribute("resultMessage", "");
		if (null != courseCode) {
			AssignInstructorService assignInstructorService = new AssignInstructorServiceImpl();
			String resultMessage = assignInstructorService.assignRoleToUser(user, courseCode);
			model.addAttribute("resultMessage", resultMessage);
		} else {
			model.addAttribute("resultMessage", ApplicationConstants.SELECT_COURSE_ERR);
		}
		return "admin/assign-instructor";
	}

}