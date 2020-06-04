package com.asdc.group6.ToolAdmin;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asdc.group6.Models.Course;
import com.asdc.group6.ToolAdmin.Service.DeleteCourseService;
import com.asdc.group6.ToolAdmin.Service.DeleteCourseServiceImpl;
import com.asdc.group6.ToolAdmin.Service.ViewCoursesService;
import com.asdc.group6.ToolAdmin.Service.ViewCoursesServiceImpl;

@Controller
public class DeleteCourseController {

	@GetMapping("/deleteCourseView")
	public String getAdminView(Model model) {
		ViewCoursesService viewCourseService = new ViewCoursesServiceImpl();
		ArrayList<Course> courseList = viewCourseService.getCourseList();
		model.addAttribute("courseList", courseList);
		model.addAttribute("deleteResultList", new ArrayList<>());
		return "DeleteCourse";
	}

	@PostMapping("deleteCourse")
	public String deleteCourseFromList(@RequestParam("course-checkbox") ArrayList<String> deleteCourseList,
			Model model) {
		if (null != deleteCourseList) {
			DeleteCourseService deleteCourseService = new DeleteCourseServiceImpl();
			ArrayList<String> deleteResultList = deleteCourseService.deleteCourse(deleteCourseList);
			model.addAttribute("deleteResultList", deleteResultList);
			model.addAttribute("courseList", new ArrayList<>());
		}
		return "DeleteCourse";
	}
}