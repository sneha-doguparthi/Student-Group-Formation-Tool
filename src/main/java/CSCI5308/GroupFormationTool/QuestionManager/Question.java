package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;

public class Question implements IQuestion {

	private int questionId;
	private String questionTitle;
	private String questionText;
	private String questionType;
	private String questionDate;
	private int questionNo;
	private String criteria;
	private int courseId;
	private ArrayList<Answer> answerList;

	public Question() {
		this.questionText = null;
		this.questionTitle = null;
		this.questionType = null;
		this.questionDate = null;
	}

	@Override
	public ArrayList<Answer> getAnswerList() {
		return answerList;
	}

	@Override
	public void setAnswerList(ArrayList<Answer> answerList) {
		this.answerList = answerList;
	}

	@Override
	public int getQuestionId() {
		return questionId;
	}

	@Override
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Override
	public String getQuestionTitle() {
		return questionTitle;
	}

	@Override
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	@Override
	public String getQuestionText() {
		return questionText;
	}

	@Override
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Override
	public String getQuestionType() {
		return questionType;
	}

	@Override
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@Override
	public String getQuestionDate() {
		return questionDate;
	}

	@Override
	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	@Override
	public int getQuestionNo() {
		return questionNo;
	}

	@Override
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	@Override
	public String getCriteria() {
		return criteria;
	}

	@Override
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
