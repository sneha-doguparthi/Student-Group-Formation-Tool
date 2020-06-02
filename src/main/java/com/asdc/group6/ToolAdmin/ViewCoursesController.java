package com.asdc.group6.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.asdc.group6.Models.Course;
import com.asdc.group6.ToolAdmin.Service.ViewCoursesServiceImpl;

@Controller
public class ViewCoursesController {

	@GetMapping("/viewCoursesView")
	public String getAdminView(Model model) {
		ViewCoursesServiceImpl viewCourseServiceImpl = new ViewCoursesServiceImpl();
		ArrayList<Course> courseList = viewCourseServiceImpl.getCourseList();
		model.addAttribute("courseList", courseList);
		return "ViewCourses.html";
	}

}