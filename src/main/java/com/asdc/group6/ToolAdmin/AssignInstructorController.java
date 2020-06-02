package com.asdc.group6.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asdc.group6.Models.Course;
import com.asdc.group6.Models.User;
import com.asdc.group6.ToolAdmin.Service.AssignInstructorServiceImpl;
import com.asdc.group6.ToolAdmin.Service.ViewCoursesServiceImpl;

@Controller
public class AssignInstructorController {

	ArrayList<Course> courseList;
	ArrayList<User> userList;

	@GetMapping("/assignInstructorView")
	public String getAdminView(Model model) {
		ViewCoursesServiceImpl viewCourseServiceImpl = new ViewCoursesServiceImpl();
		courseList = viewCourseServiceImpl.getCourseList();
		model.addAttribute("courseList", courseList);
		AssignInstructorServiceImpl assignInstructorServiceImpl = new AssignInstructorServiceImpl();
		userList = assignInstructorServiceImpl.getUserList();
		model.addAttribute("userList", userList);
		return "AssignInstructor.html";
	}

	@PostMapping("/assignRole")
	public String assignRole(@RequestParam("CourseCode") String courseCode, User user, Model model) {
		model.addAttribute("courseList", courseList);
		model.addAttribute("userList", userList);
		if (null != courseCode) {
			AssignInstructorServiceImpl assignInstructorServiceImpl = new AssignInstructorServiceImpl();
			assignInstructorServiceImpl.assignRoleToUser(user, courseCode);
		}
		return "AssignInstructor.html";
	}

}