package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.IFetchQuestionDAO;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.QuestionManagerDaoFactory;

public class FetchQuestionServiceImpl implements IFetchQuestionService {

	@Override
	public ArrayList<IQuestion> fetchQuestionForInstructor() {
		IFetchQuestionDAO fetchQuestionDAO = QuestionManagerDaoFactory.instance().fetchQuestionDAO();
		return fetchQuestionDAO.getQuestionByUserId();
	}

}
