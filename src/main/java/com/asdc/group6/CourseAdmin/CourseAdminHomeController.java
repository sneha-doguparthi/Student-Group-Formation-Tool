package com.asdc.group6.CourseAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseAdminHomeController {

	@PostMapping("/course-admin-home")
	public String searchTa(@RequestParam String id, @RequestParam String code, 
			@RequestParam String name ,Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);
		
		return "course-admin-home";
	}
}
