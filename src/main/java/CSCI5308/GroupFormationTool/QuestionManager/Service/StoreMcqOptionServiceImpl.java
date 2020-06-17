package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreMcqOptionsDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreMcqOptionsDAOImpl;

public class StoreMcqOptionServiceImpl implements StoreMcqOptionService {

	@Override
	public String saveMcqOptionsForQuestion(int questionId, ArrayList<Answer> answerList) {
		StoreMcqOptionsDAO storeMcqOptionsDAO = new StoreMcqOptionsDAOImpl();
		return storeMcqOptionsDAO.saveMcqOptionsForQuestion(questionId, answerList);
	}

}
