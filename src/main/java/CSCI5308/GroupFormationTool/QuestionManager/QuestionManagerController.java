package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.Service.StoreQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.StoreQuestionServiceImpl;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;
import CSCI5308.GroupFormationTool.QuestionManager.Service.DeleteQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.DeleteQuestionServiceImpl;
import CSCI5308.GroupFormationTool.QuestionManager.Service.FetchQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.FetchQuestionServiceImpl;
import CSCI5308.GroupFormationTool.QuestionManager.Service.SplitMcqAnswerService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.SplitMcqAnswerServiceImpl;
import CSCI5308.GroupFormationTool.QuestionManager.Service.StoreMcqOptionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.StoreMcqOptionServiceImpl;

@Controller
public class QuestionManagerController {

	Question question = new Question();

	@GetMapping("/question-manager/home")
	public String questionManagerHomePage(Model model) {
		FetchQuestionService fetchQuestionService = new FetchQuestionServiceImpl();
		model.addAttribute("questionList", fetchQuestionService.fetchQuestionForInstructor());
		return "questionmanager/question-manager-home";
	}

	@PostMapping("/question-manager/delete-question")
	public String deleteQuestionConfrimationPage(@RequestParam Integer questionId, Model model) {
		DeleteQuestionService deleteQuestionService = new DeleteQuestionServiceImpl();
		deleteQuestionService.deleteQuestionAndOptions(questionId);
		FetchQuestionService fetchQuestionService = new FetchQuestionServiceImpl();
		model.addAttribute("questionList", fetchQuestionService.fetchQuestionForInstructor());
		return "questionmanager/question-manager-home";
	}
	
	@GetMapping("/question-manager/create-question")
	public String createQuestionHomePage(Model model) {
		model.addAttribute("questionModel", question);
		return "questionmanager/create-question";
	}

	@PostMapping("/question-manager/create-question")
	public String createQuestionsRequest(Question question, Model model) {
		this.question = question;
		if (this.question.getQuestionType().equals("NUM") || this.question.getQuestionType().equals("FREETEXT")) {
			StoreQuestionService questionAnswerService = new StoreQuestionServiceImpl();
			int questionId = questionAnswerService.saveQuestionDetails(this.question);
			String questionAnswerStatus = "";
			if (questionId != -1) {
				questionAnswerStatus = ApplicationConstants.QUESTION_ANSWERS_ADDED;
			} else {
				questionAnswerStatus = ApplicationConstants.FAILED_QUESTION_ANSWERS_INSERTION;
			}
			model.addAttribute("questionAnswerStatus", questionAnswerStatus);
			this.question = new Question();
			return "questionmanager/question-answer-status";
		}
		return "questionmanager/answer";
	}

	@PostMapping("/question-manager/create-answer")
	public String createAnswerRequest(Answer answer, Model model) {
		SplitMcqAnswerService splitMcqAnswerService = new SplitMcqAnswerServiceImpl();
		ArrayList<Answer> answerList = splitMcqAnswerService.splitMcqAnswers(answer);
		this.question.setAnswerList(answerList);

		StoreQuestionService questionAnswerService = new StoreQuestionServiceImpl();
		int questionId = questionAnswerService.saveQuestionDetails(this.question);
		String questionAnswerStatus = "";
		if (!(this.question.getQuestionType().equals("NUM") || (this.question.getQuestionType().equals("FREETEXT")))) {
			StoreMcqOptionService storeMcqOptionService = new StoreMcqOptionServiceImpl();
			questionAnswerStatus = storeMcqOptionService.saveMcqOptionsForQuestion(questionId, answerList);
		}
		if (questionId != -1) {
			questionAnswerStatus = ApplicationConstants.QUESTION_ANSWERS_ADDED;
		} else {
			questionAnswerStatus = ApplicationConstants.FAILED_QUESTION_ANSWERS_INSERTION;
		}

		model.addAttribute("questionAnswerStatus", questionAnswerStatus);
		this.question = new Question();
		return "questionmanager/question-answer-status";
	}

}
