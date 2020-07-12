package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

public interface ISurvey {
	public int getSurveyId();

	public void setSurveyId(int surveyId);

	public List<SurveyQuestion> getQuestionList();

	public void setQuestionList(List<SurveyQuestion> questionList);

	public String getCourseId();

	public void setCourseId(String courseId);

	public boolean isPublished();

	public void setPublished(boolean published);

	public int getGroupSize();

	public void setGroupSize(int groupSize);
}
