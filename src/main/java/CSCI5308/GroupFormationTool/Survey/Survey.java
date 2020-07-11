package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

public class Survey implements ISurvey {
	private int surveyId;
	private List<SurveyQuestion> questionList;

	@Override
	public int getSurveyId() {
		return surveyId;
	}

	@Override
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	@Override
	public List<SurveyQuestion> getQuestionList() {
		return questionList;
	}

	@Override
	public void setQuestionList(List<SurveyQuestion> questionList) {
		this.questionList = questionList;
	}

}
