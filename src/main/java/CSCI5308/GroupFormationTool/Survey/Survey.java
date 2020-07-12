package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.Service.ISurveyService;

public class Survey implements ISurvey {
	private int surveyId;
	private List<IQuestion> questionList;
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
	public List<IQuestion> getQuestionList() {
		return questionList;
	}

	@Override
	public void setQuestionList(List<IQuestion> questionList) {
		this.questionList = questionList;
	}

	@Override
	public ISurvey getSurveyForCourse(ICourse course, ISurveyService surveyService) {
		return surveyService.getSurveyForCourse(course);
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
