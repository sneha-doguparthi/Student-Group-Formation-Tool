package CSCI5308.GroupFormationTool.Model;

import java.util.ArrayList;

public class Question {
	private int questionId;
	private String questionTitle;
	private String questionText;
	private String questionType;
	private String questionDate;
	private int questionNo;
	private ArrayList<Answer> answerList;

	public Question() {
		this.questionText = null;
		this.questionTitle = null;
		this.questionType = null;
		this.questionDate = null;
	}

	public ArrayList<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(ArrayList<Answer> answerList) {
		this.answerList = answerList;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}
	
	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

}
