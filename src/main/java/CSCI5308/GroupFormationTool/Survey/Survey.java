package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

public class Survey implements ISurvey {
	private int surveyId;
	private List<SurveyQuestion> questionList;
	private String courseId;
	private boolean isPublished;
	private int groupSize;

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

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean published) {
		isPublished = published;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

}
