package CSCI5308.GroupFormationTool.Survey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import CSCI5308.GroupFormationTool.Survey.Service.ISaveSurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.Service.IGetQuestionsService;
import CSCI5308.GroupFormationTool.Survey.Service.SurveyServiceFactory;

@Controller
public class SurveyController {

	ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
	IGetQuestionsService getQuestionsService = SurveyServiceFactory.instance().getQuestionsService();
	private String courseId;

	@GetMapping("/survey/create-survey")
	public String getAllQuestions(Model model, HttpServletRequest request) {
		this.courseId=request.getParameter("courseId");
        survey.setCourseId(Integer.parseInt(courseId));
		ArrayList<IQuestion>  questionslist = getQuestionsService.getQuestionForInstructor();
		model.addAttribute("questions", questionslist);
        model.addAttribute("surveyModel", survey);
		return ("survey/create-survey");
	}

	@PostMapping("/survey/addQuestions")
	public String addQuestionsToSurvey(Model model, HttpServletRequest httpServletRequest) {
		String questionId = httpServletRequest.getParameter("questionSelected");
		this.survey=getQuestionsService.getOneQuestion(survey, Integer.parseInt(questionId));
		ArrayList<IQuestion>  questionslist = getQuestionsService.getQuestionForInstructor();
		model.addAttribute("questions", questionslist);
        model.addAttribute("surveyModel", survey);
		return ("survey/create-survey");
	}

	@GetMapping("/survey/delete-question/{questionid}")
	public String deleteQuestion(@PathVariable("questionid") int questionId,Model model) {
		this.survey = getQuestionsService.deleteQuestion(survey, questionId);
		ArrayList<IQuestion>  questionslist = getQuestionsService.getQuestionForInstructor();
		model.addAttribute("questions", questionslist);
        model.addAttribute("surveyModel", survey);
		return ("survey/create-survey");
	}

	@PostMapping("/survey/save-survey")
	public String saveSurvey(@ModelAttribute("surveyModel") Survey surveyData, String selectedQuestionInfo,Model model) {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		ISaveSurveyService saveSurveyService = SurveyServiceFactory.instance().saveSurveyService();
		IGetQuestionsService getQuestionsService = SurveyServiceFactory.instance().getQuestionsService();
		model.addAttribute("surveyModel", survey);
        List<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
        model.addAttribute("questions", questionslist);
		List<IQuestion> questionDetails=saveSurveyService.splitQuestionDetails(selectedQuestionInfo);
		survey.setCourseId(Integer.parseInt(courseId));
		survey.setGroupSize(surveyData.getGroupSize());
		saveSurveyService.saveSurveyDetails(survey);
		saveSurveyService.saveSurveyQuestions(questionDetails,Integer.parseInt(courseId));
		return ("survey/create-survey");
	}

	@PostMapping("/survey/publish")
	public String publish(){
		ISaveSurveyService saveSurveyService = SurveyServiceFactory.instance().saveSurveyService();
		saveSurveyService.updateSurveyStatus(Integer.parseInt(courseId));
		return ("survey/publish-survey");
	}



}
