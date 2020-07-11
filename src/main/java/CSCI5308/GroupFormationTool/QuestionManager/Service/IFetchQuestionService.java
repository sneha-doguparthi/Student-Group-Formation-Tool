package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Question;

public interface IFetchQuestionService {

	public ArrayList<Question> fetchQuestionForInstructor();

}
