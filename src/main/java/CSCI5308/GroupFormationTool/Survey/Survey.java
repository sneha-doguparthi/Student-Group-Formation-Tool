package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.Service.ISurveyService;

public class Survey implements ISurvey {
	private int surveyId;
	private List<IQuestion> questionList;
	private int courseId;
	private String surveyStatus;
	private int groupSize;
	private List<String> criteriaList;

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
	public List<String> getCriteriaList() {
		return criteriaList;
	}

	@Override
	public void setCriteriaList(List<String> criteriaList) {
		this.criteriaList = criteriaList;
	}

	@Override
	public ISurvey getSurveyForCourse(ICourse course, ISurveyService surveyService) {
		return surveyService.getSurveyForCourse(course);
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}

	public String getSurveyStatus() {
		return surveyStatus;
	}

	public void setSurveyStatus(String surveyStatus) {
		this.surveyStatus = surveyStatus;
	}

}
