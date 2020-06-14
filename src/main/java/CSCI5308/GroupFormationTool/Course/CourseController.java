package CSCI5308.GroupFormationTool.Course;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAO;
import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAOImpl;
import CSCI5308.GroupFormationTool.Course.DAO.CourseDao;
import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoImpl;
import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

@Controller
public class CourseController {
	@GetMapping("/courses/home")
	public String coursesHomeRequest(@RequestParam int userId, Model model) {

		CourseAssociationDAO courseAssociationDao = new CourseAssociationDAOImpl();
		CourseDao courseDao = new CourseDaoImpl();
		// check inside association table for logged in user
		ArrayList<CourseAssociation> associationList = courseAssociationDao.getByUserId(userId);

		// if user is student and also a TA then differentiate both entries

		ArrayList<Course> courseListAsStudent = new ArrayList<Course>();
		ArrayList<Course> courseListAsTA = new ArrayList<Course>();
		ArrayList<Course> courseListAsInstructor = new ArrayList<Course>();

		// Initializing all the model attributes
		model.addAttribute("allCourses", new ArrayList<Course>());
		model.addAttribute("courseListAsStudent", new ArrayList<Course>());
		model.addAttribute("courseListAsTA", new ArrayList<Course>());
		model.addAttribute("courseListAsInstructor", new ArrayList<Course>());

		// If user is not enrolled in any courses then list all courses
		// this would be the guest user case
		if (associationList.size() == 0) {
			ArrayList<Course> courses = courseDao.getAll();
			model.addAttribute("allCourses", courses);
			return "course/courses-home";
		}

		for (CourseAssociation a : associationList) {
			if (a.getRoleId() == (ApplicationConstants.STUDENT_ROLE_ID)) {
				courseListAsStudent.add(courseDao.getById(a.getCourseId()));
			} else if (a.getRoleId() == (ApplicationConstants.TA_ROLE_ID)) {
				courseListAsTA.add(courseDao.getById(a.getCourseId()));
			} else if (a.getRoleId() == (ApplicationConstants.INSTRUCTOR_ROLE_ID)) {
				courseListAsInstructor.add(courseDao.getById(a.getCourseId()));
			}
		}
		// Updating model attributes for data fetched
		model.addAttribute("courseListAsStudent", courseListAsStudent);
		model.addAttribute("courseListAsTA", courseListAsTA);
		model.addAttribute("courseListAsInstructor", courseListAsInstructor);
		return "course/courses-home";
	}

	@PostMapping("/course/student-course-home")
	public String studentHome(@RequestParam String courseName, Model model) {
		model.addAttribute("courseName", courseName);
		return "/course/student-course-home";
	}
}
