package CSCI5308.GroupFormationTool.QuestionManager.Service;

import CSCI5308.GroupFormationTool.QuestionManager.DAO.IDeleteQuestionDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.QuestionManagerDaoFactory;

public class DeleteQuestionServiceImpl implements IDeleteQuestionService {

	@Override
	public boolean deleteQuestionAndOptions(Integer questionId) {
		IDeleteQuestionDAO deleteQuestionDAO = QuestionManagerDaoFactory.instance().deleteQuestionDAO();
		deleteQuestionDAO.deleteQuestionByQuestionId(questionId);
		return true;
	}

}
