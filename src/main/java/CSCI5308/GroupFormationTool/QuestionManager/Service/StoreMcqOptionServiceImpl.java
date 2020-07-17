package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.IStoreMcqOptionsDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.QuestionManagerDaoFactory;

public class StoreMcqOptionServiceImpl implements IStoreMcqOptionService {

	@Override
	public String saveMcqOptionsForQuestion(int questionId, ArrayList<Answer> answerList) {
		IStoreMcqOptionsDAO storeMcqOptionsDAO = QuestionManagerDaoFactory.instance().storeMcqOptionsDAO();
		return storeMcqOptionsDAO.saveMcqOptionsForQuestion(questionId, answerList);
	}

}
