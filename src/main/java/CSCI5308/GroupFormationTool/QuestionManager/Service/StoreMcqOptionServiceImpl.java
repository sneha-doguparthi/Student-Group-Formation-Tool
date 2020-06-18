package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.StoreMcqOptionsDAO;

public class StoreMcqOptionServiceImpl implements StoreMcqOptionService {

	@Override
	public String saveMcqOptionsForQuestion(int questionId, ArrayList<Answer> answerList) {
		StoreMcqOptionsDAO storeMcqOptionsDAO = SystemConfig.instance().getStoreMcqOptionsDAO();
		return storeMcqOptionsDAO.saveMcqOptionsForQuestion(questionId, answerList);
	}

}
