package com.asdc.group6.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asdc.group6.Models.Course;
import com.asdc.group6.Models.User;
import com.asdc.group6.ToolAdmin.Service.AssignInstructorService;
import com.asdc.group6.ToolAdmin.Service.AssignInstructorServiceImpl;
import com.asdc.group6.ToolAdmin.Service.ViewCoursesService;
import com.asdc.group6.ToolAdmin.Service.ViewCoursesServiceImpl;
import com.asdc.group6.Utilities.ApplicationConstants;

@Controller
public class AssignInstructorController {

	ArrayList<Course> courseList;
	ArrayList<User> userList;

	@GetMapping("/assign-instructor")
	public String getAdminView(Model model) {
		ViewCoursesService viewCourseService = new ViewCoursesServiceImpl();
		courseList = viewCourseService.getCourseList();
		model.addAttribute("courseList", courseList);
		AssignInstructorService assignInstructorService = new AssignInstructorServiceImpl();
		userList = assignInstructorService.getUserList();
		model.addAttribute("userList", userList);
		model.addAttribute("resultMessage", "");
		return "assign-instructor";
	}

	@PostMapping("/assign-role")
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
		return "assign-instructor";
	}

}