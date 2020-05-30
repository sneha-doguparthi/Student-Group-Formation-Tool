package com.asdc.group6.ToolAdmin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssignInstructorController {

	@GetMapping("/assignInstructorView")
	public String getAdminView() {
		return "AssignInstructor.html";
	}

}