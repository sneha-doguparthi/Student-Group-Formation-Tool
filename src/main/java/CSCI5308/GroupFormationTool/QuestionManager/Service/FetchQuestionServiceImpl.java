package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.FetchQuestionDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.FetchQuestionDAOImpl;

public class FetchQuestionServiceImpl implements FetchQuestionService {

	@Override
	public ArrayList<Question> fetchQuestionForInstructor() {
		FetchQuestionDAO fetchQuestionDAO = new FetchQuestionDAOImpl();
		return fetchQuestionDAO.getQuestionByUserId();
	}
	
}
