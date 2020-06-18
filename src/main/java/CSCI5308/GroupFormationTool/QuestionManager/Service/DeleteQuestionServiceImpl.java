package CSCI5308.GroupFormationTool.QuestionManager.Service;

import CSCI5308.GroupFormationTool.QuestionManager.DAO.DeleteQuestionDAO;
import CSCI5308.GroupFormationTool.SystemConfig;

public class DeleteQuestionServiceImpl implements DeleteQuestionService {

	@Override
	public boolean deleteQuestionAndOptions(Integer questionId) {
		DeleteQuestionDAO deleteQuestionDAO = SystemConfig.instance().getDeleteQuestionDAO();
		deleteQuestionDAO.deleteQuestionByQuestionId(questionId);
		return true;
	}
	
}
