package CSCI5308.GroupFormationTool.QuestionManager.Service;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.IStoreQuestionDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.QuestionManagerDaoFactory;

public class StoreQuestionServiceImpl implements IStoreQuestionService {

	@Override
	public int saveQuestionDetails(IQuestion question) {
		IStoreQuestionDAO questionAnswer = QuestionManagerDaoFactory.instance().storeQuestionDAO();
		return questionAnswer.saveQuestionDetails(question);
	}
}
