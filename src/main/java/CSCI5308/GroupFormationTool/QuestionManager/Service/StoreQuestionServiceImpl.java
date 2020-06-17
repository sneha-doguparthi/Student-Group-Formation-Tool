package CSCI5308.GroupFormationTool.QuestionManager.Service;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreQuestionDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreQuestionDAOImpl;

public class StoreQuestionServiceImpl implements StoreQuestionService {

	@Override
	public int saveQuestionDetails(Question question) {
		StoreQuestionDAO questionAnswer = new StoreQuestionDAOImpl();
		return questionAnswer.saveQuestionDetails(question);
	}
}
