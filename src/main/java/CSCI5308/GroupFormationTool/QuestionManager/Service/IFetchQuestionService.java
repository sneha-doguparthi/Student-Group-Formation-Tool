package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

public interface IFetchQuestionService {

	public ArrayList<IQuestion> fetchQuestionForInstructor();

}
