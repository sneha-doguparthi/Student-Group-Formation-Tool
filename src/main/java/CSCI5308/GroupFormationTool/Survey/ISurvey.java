package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

public interface ISurvey {
	public int getSurveyId();

	public void setSurveyId(int surveyId);

	public List<SurveyQuestion> getQuestionList();

	public void setQuestionList(List<SurveyQuestion> questionList);

}
