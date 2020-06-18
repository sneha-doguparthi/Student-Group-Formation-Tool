package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Question;

public interface FetchQuestionService {
	public ArrayList<Question> fetchQuestionForInstructor();
}
