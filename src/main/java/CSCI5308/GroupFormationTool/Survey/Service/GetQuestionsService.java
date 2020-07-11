package CSCI5308.GroupFormationTool.Survey.Service;

import CSCI5308.GroupFormationTool.Model.Question;

import java.util.ArrayList;

public interface GetQuestionsService {
    ArrayList<Question> getQuestionForInstructor();
    Question getOneQuestion(int questionId);
}
