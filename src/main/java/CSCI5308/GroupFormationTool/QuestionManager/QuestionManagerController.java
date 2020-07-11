package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.QuestionManager.Service.IDeleteQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.IFetchQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.ISplitMcqAnswerService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.IStoreMcqOptionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.IStoreQuestionService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.ServiceFactory;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

@Controller
public class QuestionManagerController {

	IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
	IStoreQuestionService storeQuestionService;
	ISplitMcqAnswerService splitMcqAnswerService;
	IStoreMcqOptionService storeMcqOptionService;
	IFetchQuestionService fetchQuestionService;
	IDeleteQuestionService deleteQuestionService;

	public QuestionManagerController() {
		storeQuestionService = ServiceFactory.instance().storeQuestionService();
		splitMcqAnswerService = ServiceFactory.instance().splitMcqAnswerService();
		storeMcqOptionService = ServiceFactory.instance().storeMcqOptionService();
		fetchQuestionService = ServiceFactory.instance().fetchQuestionService();
		deleteQuestionService = ServiceFactory.instance().deleteQuestionService();
	}

	@GetMapping("/question-manager/home")
	public String questionManagerHomePage(Model model) {

		model.addAttribute("questionList", fetchQuestionService.fetchQuestionForInstructor());

		return "questionmanager/question-manager-home";
	}

	@PostMapping("/question-manager/delete-question")
	public String deleteQuestionConfrimationPage(@RequestParam Integer questionId, Model model) {

		deleteQuestionService.deleteQuestionAndOptions(questionId);

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
			int questionId = storeQuestionService.saveQuestionDetails(this.question);
			String questionAnswerStatus = "";
			if (questionId != -1) {
				questionAnswerStatus = ApplicationConstants.QUESTION_ANSWERS_ADDED;
			} else {
				questionAnswerStatus = ApplicationConstants.FAILED_QUESTION_ANSWERS_INSERTION;
			}
			model.addAttribute("questionAnswerStatus", questionAnswerStatus);
			this.question = QuestionFactory.questionObject(new QuestionObjectFactory());
			return "questionmanager/question-answer-status";
		}

		return "questionmanager/answer";
	}

	@PostMapping("/question-manager/create-answer")
	public String createAnswerRequest(Answer answer, Model model) {

		ArrayList<Answer> answerList = splitMcqAnswerService.splitMcqAnswers(answer);
		this.question.setAnswerList(answerList);
		int questionId = storeQuestionService.saveQuestionDetails(this.question);
		String questionAnswerStatus = "";

		if (!(this.question.getQuestionType().equals("NUM") || (this.question.getQuestionType().equals("FREETEXT")))) {
			questionAnswerStatus = storeMcqOptionService.saveMcqOptionsForQuestion(questionId, answerList);
		}
		if (questionId != -1) {
			questionAnswerStatus = ApplicationConstants.QUESTION_ANSWERS_ADDED;
		} else {
			questionAnswerStatus = ApplicationConstants.FAILED_QUESTION_ANSWERS_INSERTION;
		}

		model.addAttribute("questionAnswerStatus", questionAnswerStatus);
		this.question = QuestionFactory.questionObject(new QuestionObjectFactory());

		return "questionmanager/question-answer-status";
	}

}
