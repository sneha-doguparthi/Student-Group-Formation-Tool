package com.asdc.group6.ToolAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddCourseController {
	
	@GetMapping("/addCourseView")
	public String addCourse() {
		return "AddCourse.Html";
	}
}
