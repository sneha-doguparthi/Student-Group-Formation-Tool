package com.asdc.group6.CourseAdmin;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@PostMapping("/assign-ta")
	public String searchTa(@RequestParam String id, @RequestParam String code, 
			@RequestParam String name, Model model) {
		
		ArrayList<User> users = assignTaService.getAllUsers();
		model.addAttribute("users", users);
		
		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("name", name);
		
		return "assign-ta";
	}
	
	@PostMapping("/do-assign-ta")
	public String assignTa(@RequestParam String id, @RequestParam String code, 
			@RequestParam String name, @RequestParam String userId) {
		
		assignTaService.assignTa(userId, Integer.valueOf(id));
		
		return "assign-ta-success";
	}
}
