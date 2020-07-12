package CSCI5308.GroupFormationTool.Survey.DAO;

import CSCI5308.GroupFormationTool.Survey.SurveyQuestion;

import java.util.List;

public interface ISaveSurveyDAO {
    boolean saveSurveyQuestions(List<SurveyQuestion> questions);
}
