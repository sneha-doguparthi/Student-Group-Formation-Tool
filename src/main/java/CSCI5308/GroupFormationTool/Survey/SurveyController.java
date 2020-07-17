package CSCI5308.GroupFormationTool.Survey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Course.CourseFactory;
import CSCI5308.GroupFormationTool.Course.CourseObjectFactory;
import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.Service.IDesignGroupService;
import CSCI5308.GroupFormationTool.Survey.Service.IGetQuestionsService;
import CSCI5308.GroupFormationTool.Survey.Service.ISaveSurveyService;
import CSCI5308.GroupFormationTool.Survey.Service.ISurveyService;
import CSCI5308.GroupFormationTool.Survey.Service.SurveyServiceFactory;

@Controller
public class SurveyController {

	ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
	IGetQuestionsService getQuestionsService = SurveyServiceFactory.instance().getQuestionsService();
	ISurveyService surveyService = SurveyServiceFactory.instance().surveyService();
	ICourse course = CourseFactory.courseObject(new CourseObjectFactory());
	private String courseId;
	int flag = 0;

	@GetMapping("/survey/create-survey")
	public String getAllQuestions(Model model, HttpServletRequest request) {
		this.courseId = request.getParameter("courseId");
		course.setCourseId(Integer.parseInt(courseId));
		if (flag == 0) {
			survey = surveyService.getSurveyForCourse(course);
		}
		if (null != survey.getSurveyStatus() && survey.getSurveyStatus().equals("A")) {
			survey.setSurveyStatus("Available");
		}
		ArrayList<IQuestion> questionsList = getQuestionsService.getQuestionForInstructor();
		flag = 0;
		model.addAttribute("questions", questionsList);
		model.addAttribute("surveyModel", survey);
		model.addAttribute("courseId", courseId);
		return ("survey/create-survey");
	}

	@PostMapping("/survey/addQuestions")
	public String addQuestionsToSurvey(@RequestParam String groupSize, Model model, HttpServletRequest httpServletRequest) {
		String questionId = httpServletRequest.getParameter("questionSelected");
		survey.setGroupSize(Integer.parseInt(groupSize));
		this.survey = getQuestionsService.getOneQuestion(survey, Integer.parseInt(questionId));
		ArrayList<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
		flag = 1;
		model.addAttribute("questions", questionslist);
		model.addAttribute("surveyModel", survey);
		return ("survey/create-survey");
	}

	@GetMapping("/survey/delete-question/{questionid}")
	public String deleteQuestion(Model model, @PathVariable("questionid") int questionId) {
		this.survey = getQuestionsService.deleteQuestion(survey, questionId);
		ArrayList<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
		ISaveSurveyService saveSurveyService = SurveyServiceFactory.instance().saveSurveyService();
		saveSurveyService.deleteSurveyQuestion(questionId, Integer.parseInt(courseId));
		flag = 1;
		model.addAttribute("questions", questionslist);
		model.addAttribute("surveyModel", survey);
		return ("survey/create-survey");
	}

	 @PostMapping("/survey/save-survey")
	 public String saveSurvey(@ModelAttribute("surveyModel") Survey surveyData, String selectedQuestionInfo, Model model) {
	 	ISaveSurveyService saveSurveyService = SurveyServiceFactory.instance().saveSurveyService();
	    survey.setGroupSize(surveyData.getGroupSize());
	    survey.setCourseId(Integer.parseInt(courseId));
	 	List<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
        List<IQuestion> questionDetails = saveSurveyService.splitQuestionDetails(selectedQuestionInfo);
        saveSurveyService.saveSurveyDetails(survey);
 	 	saveSurveyService.saveSurveyQuestions(questionDetails, Integer.parseInt(courseId));
        flag = 1;
        survey = surveyService.getSurveyForCourse(course);
 	 	model.addAttribute("surveyModel", survey);
	 	model.addAttribute("questions", questionslist);
	 	return ("survey/create-survey");
	 }

	 @PostMapping("/survey/publish")
	 public String publish(@ModelAttribute("surveyModel") Survey surveyData, String selectedQuestionInfo){
	 	ISaveSurveyService saveSurveyService = SurveyServiceFactory.instance().saveSurveyService();
	 	survey.setGroupSize(surveyData.getGroupSize());
	 	survey.setCourseId(Integer.parseInt(courseId));
	 	survey.setSurveyStatus("Available");
	    saveSurveyService.saveSurveyDetails(survey);
	 	saveSurveyService.updateSurveyStatus(Integer.parseInt(courseId));
	 	return ("survey/publish-survey");
	 }

	@GetMapping("/survey/design-group")
	public String designGroup(HttpServletRequest request, Model model) {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		IDesignGroupService designGroupService = SurveyServiceFactory.instance().designGroupService();
		Map<String, ArrayList<String>> groupInformation = designGroupService.designGroup(courseId);
		ArrayList<String> groupedList = groupInformation.get("groupedUser");
		ArrayList<String> unGroupedList = groupInformation.get("unGroupedUser");
		model.addAttribute("groupedUser", groupedList.toArray());
		model.addAttribute("unGroupedUser", unGroupedList.toArray());
		return "survey/design-group";
	}
}
