package com.asdc.group6.CourseAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.asdc.group6.Models.User;

@Controller
public class CourseAdminHomeController {

	@GetMapping("/course-admin-home")
	public String searchTa(Model model) {
		
		return "course-admin-home";
	}
}
