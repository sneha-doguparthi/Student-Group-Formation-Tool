package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;

public interface ISplitMcqAnswerService {

	public ArrayList<Answer> splitMcqAnswers(Answer answer);

}
