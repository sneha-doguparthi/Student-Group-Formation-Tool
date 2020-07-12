package CSCI5308.GroupFormationTool.Survey;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import CSCI5308.GroupFormationTool.Survey.Service.IGetQuestionsService;
import CSCI5308.GroupFormationTool.Survey.Service.SurveyServiceFactory;

@Controller
public class SurveyController {

	IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
	IGetQuestionsService getQuestionsService = SurveyServiceFactory.instance().getQuestionsService();

	@GetMapping("/survey/create-survey")
	public String getAllQuestions(Model model) {
		ArrayList<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
		model.addAttribute("questions", questionslist);
		model.addAttribute("questionModel", question);
		return ("survey/create-survey");
	}

	@PostMapping("/survey/addQuestions")
	public String addQuestionsToSurvey(Model model, HttpServletRequest httpServletRequest) {
		String questionId = httpServletRequest.getParameter("questionSelected");
		ArrayList<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
		model.addAttribute("questions", questionslist);
		ISurvey question = getQuestionsService.getOneQuestion(Integer.parseInt(questionId));
		model.addAttribute("surveyQuestions", question.getQuestionList());
		return ("survey/create-survey");
	}

	@PostMapping("/survey/delete-question")
	public String deleteQuestion(Model model, HttpServletRequest httpServletRequest) {
		String questionId = httpServletRequest.getParameter("deleteQuestionId");
		return ("survey/create-survey");
	}

}
