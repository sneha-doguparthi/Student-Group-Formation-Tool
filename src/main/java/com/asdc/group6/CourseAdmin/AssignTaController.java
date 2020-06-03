package com.asdc.group6.CourseAdmin;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.asdc.group6.CourseAdmin.Service.AssignTaService;
import com.asdc.group6.Models.User;

@Controller
public class AssignTaController {
	
	private AssignTaService assignTaService;
	
	public AssignTaController(AssignTaService assignTaService) {
		this.assignTaService = assignTaService;
	}

	@GetMapping("/assign-ta")
	public String searchTa(Model model) {
		
		ArrayList<User> users = assignTaService.getAllUsers();
		model.addAttribute("users", users);
		
		return "assign-ta";
	}
	
	@PostMapping("/assign-ta")
	public String assignTa(@RequestParam String userId) {
		
		assignTaService.assignTa(userId, 1);
		
		return "assign-ta-success";
	}
}
