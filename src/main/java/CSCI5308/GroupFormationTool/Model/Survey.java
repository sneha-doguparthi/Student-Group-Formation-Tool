package CSCI5308.GroupFormationTool.Model;

import java.util.ArrayList;

public class Survey {
    private static int surveyId;
    private ArrayList<Question> questionArrayList;

    public static int getSurveyId() {
        return surveyId;
    }

    public static void setSurveyId(int surveyId) {
        Survey.surveyId = surveyId;
    }

    public ArrayList<Question> getQuestionArrayList() {
        return questionArrayList;
    }

    public void setQuestionArrayList(ArrayList<Question> questionArrayList) {
        this.questionArrayList = questionArrayList;
    }

}
