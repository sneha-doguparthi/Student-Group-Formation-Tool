package CSCI5308.GroupFormationTool.Model;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    private static int surveyId;

    private List<SurveyQuestion> questionList;

    public static int getSurveyId() {
        return surveyId;
    }

    public static void setSurveyId(int surveyId) {
        Survey.surveyId = surveyId;
    }
    public List<SurveyQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<SurveyQuestion> questionList) {
        this.questionList = questionList;
    }

}

