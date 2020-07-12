package CSCI5308.GroupFormationTool.Course;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoFactory;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseAssociationDao;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseDao;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;
import CSCI5308.GroupFormationTool.Survey.Service.ISurveyService;
import CSCI5308.GroupFormationTool.Survey.Service.SurveyServiceFactory;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

@Controller
public class CourseController {

	ICourseAssociationDao courseAssociationDAO;
	ICourseDao courseDao;

	public CourseController() {
		this.courseAssociationDAO = CourseDaoFactory.instance().courseAssociationDao();
		this.courseDao = CourseDaoFactory.instance().courseDao();
	}

	@GetMapping("/courses/home")
	public String coursesHomeRequest(@RequestParam int userId, Model model) {

		ArrayList<CourseAssociation> associationList = courseAssociationDAO.getByUserId(userId);

		ArrayList<ICourse> courseListAsStudent = new ArrayList<ICourse>();
		ArrayList<ICourse> courseListAsTA = new ArrayList<ICourse>();
		ArrayList<ICourse> courseListAsInstructor = new ArrayList<ICourse>();

		model.addAttribute("allCourses", new ArrayList<Course>());
		model.addAttribute("courseListAsStudent", new ArrayList<Course>());
		model.addAttribute("courseListAsTA", new ArrayList<Course>());
		model.addAttribute("courseListAsInstructor", new ArrayList<Course>());

		if (associationList.size() == 0) {
			ArrayList<ICourse> courses = courseDao.getAll();
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
		model.addAttribute("courseListAsStudent", courseListAsStudent);
		model.addAttribute("courseListAsTA", courseListAsTA);
		model.addAttribute("courseListAsInstructor", courseListAsInstructor);

		return "course/courses-home";
	}

	@PostMapping("/course/student-course-home")
	public String studentHome(Course course, Model model) {
		model.addAttribute("courseName", course.getCourseName());
		model.addAttribute("courseHasActiveSurvey", false);

		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		ISurveyService surveyService = SurveyServiceFactory.instance().surveyService();
		survey = surveyService.getSurveyForCourse(course);
		model.addAttribute("surveyInfo", survey);
		if (null != survey && survey.getQuestionList().size() > 0) {
			model.addAttribute("courseHasActiveSurvey", true);
		}
		return "course/student-course-home";
	}
}
