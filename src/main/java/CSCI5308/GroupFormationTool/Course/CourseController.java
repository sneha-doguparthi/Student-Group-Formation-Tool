package CSCI5308.GroupFormationTool.Course;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoFactory;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseAssociationDao;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseDao;
import CSCI5308.GroupFormationTool.Course.Service.CourseServiceFactory;
import CSCI5308.GroupFormationTool.Course.Service.ICourseSurveyService;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;
import CSCI5308.GroupFormationTool.Survey.Service.ISurveyService;
//import CSCI5308.GroupFormationTool.Survey.Service.ISurveyService;
import CSCI5308.GroupFormationTool.Survey.Service.SurveyServiceFactory;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

@Controller
public class CourseController {

	private Logger logger = LogManager.getLogger(CourseController.class);
	ICourseAssociationDao courseAssociationDAO;
	ICourseDao courseDao;
	ICourse course;
	ISurvey survey;
	int userId;
	ICourseSurveyService courseSurveyService;

	public CourseController() {
		this.courseAssociationDAO = CourseDaoFactory.instance().courseAssociationDao();
		this.courseDao = CourseDaoFactory.instance().courseDao();
		this.course = CourseFactory.courseObject(new CourseObjectFactory());
		this.survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		this.courseSurveyService = CourseServiceFactory.instance().courseSurveyService();
	}

	@GetMapping("/courses/home")
	public String coursesHomeRequest(@RequestParam int userId, Model model) {

		ArrayList<CourseAssociation> associationList = courseAssociationDAO.getByUserId(userId);

		ArrayList<ICourse> courseListAsStudent = new ArrayList<ICourse>();
		ArrayList<ICourse> courseListAsTA = new ArrayList<ICourse>();
		ArrayList<ICourse> courseListAsInstructor = new ArrayList<ICourse>();
		this.userId = userId;
		logger.info("Course home page launched by user: ", userId);
		logger.info("Initializing the model attributes");
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
		model.addAttribute("userId", userId);

		return "course/courses-home";
	}

	@PostMapping("/course/student-course-home")
	public String studentHome(Course course, Model model, int userId) {
		logger.info("Performing intial checks for the course survey.");
		this.course = course;
		this.userId = userId;
		model = initializeCourseModel(model);
		ISurveyService surveyService = SurveyServiceFactory.instance().surveyService();
		this.survey = surveyService.getSurveyForCourse(course);
		model.addAttribute("surveyInfo", this.survey);
		if (null != survey && null != survey.getQuestionList() && survey.getQuestionList().size() > 0) {
			boolean userSubmittedResponse = this.courseSurveyService.checkIfSurveySubmitted(this.course.getCourseId(),
					this.userId);
			if (userSubmittedResponse) {
				model.addAttribute("courseHasActiveSurvey", false);
				model.addAttribute("surveySubmissionResponse", ApplicationConstants.SURVEY_RESPONSE_SAVED);
			} else {
				model.addAttribute("courseHasActiveSurvey", true);
			}
		}
		model.addAttribute("question", QuestionFactory.questionObject(new QuestionObjectFactory()));
		return "course/student-course-home";
	}

	@PostMapping("/course/student-survey-response")
	public String surveyResponseHome(@ModelAttribute Question question, Model model, int userId) {
		logger.info("Request for storing the responses of survey questions.");
		this.userId = userId;
		model = initializeCourseModel(model);
		boolean validatioResult = this.courseSurveyService.validateResponses(question, this.survey);
		if (validatioResult) {
			ArrayList<SurveyResponse> surveyResponseList = courseSurveyService.splitSurveyResponse(question);
			for (SurveyResponse surveyResponseObj : surveyResponseList) {
				surveyResponseObj.setUserId(this.userId);
				surveyResponseObj.setCourseId(this.course.getCourseId());
			}
			String surveyResponse = courseSurveyService.storeSurveyResponse(surveyResponseList);
			model.addAttribute("surveySubmissionResponse", surveyResponse);
			model.addAttribute("courseHasActiveSurvey", false);
		} else {
			model.addAttribute("courseHasActiveSurvey", true);
			model.addAttribute("errMsg", "Please answer all questions");
		}
		return "course/student-course-home";
	}

	public Model initializeCourseModel(Model courseHomeModel) {
		logger.info("Initializing the model attributes for survey section.");
		courseHomeModel.addAttribute("courseName", this.course.getCourseName());
		courseHomeModel.addAttribute("courseHasActiveSurvey", false);
		courseHomeModel.addAttribute("errMsg", "");
		courseHomeModel.addAttribute("surveySubmissionResponse", "");
		courseHomeModel.addAttribute("surveyInfo", this.survey);
		courseHomeModel.addAttribute("userId", this.userId);
		return courseHomeModel;
	}

}
