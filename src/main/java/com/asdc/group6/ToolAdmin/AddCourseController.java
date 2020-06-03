package com.asdc.group6.ToolAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.asdc.group6.Models.Course;
import com.asdc.group6.ToolAdmin.Service.AddCourseService;
import com.asdc.group6.ToolAdmin.Service.AddCourseServiceImpl;

@Controller
public class AddCourseController {

	@GetMapping("/addCourseView")
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		return "AddCourse.Html";
	}

	@PostMapping("/addNewCourse")
	public String addNewCourse(Course course, Model model) {
		AddCourseService addCourseService = new AddCourseServiceImpl();
		String courseAddResult = addCourseService.addNewCourse(course);
		model.addAttribute("course", new Course());
		model.addAttribute("resultMessage", courseAddResult);
		return "AddCourse.Html";
	}
}
