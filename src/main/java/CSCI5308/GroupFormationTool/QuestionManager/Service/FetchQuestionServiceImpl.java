package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.FetchQuestionDAO;
import CSCI5308.GroupFormationTool.SystemConfig;

public class FetchQuestionServiceImpl implements FetchQuestionService {

	@Override
	public ArrayList<Question> fetchQuestionForInstructor() {
		FetchQuestionDAO fetchQuestionDAO = SystemConfig.instance().getFetchQuestionDAO();
		return fetchQuestionDAO.getQuestionByUserId();
	}
	
}
