package CSCI5308.GroupFormationTool.QuestionManager.Service;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreQuestionDAO;

public class StoreQuestionServiceImpl implements StoreQuestionService {

	@Override
	public int saveQuestionDetails(Question question) {
		StoreQuestionDAO questionAnswer = SystemConfig.instance().getStoreQuestionDAO();
		return questionAnswer.saveQuestionDetails(question);
	}
}
