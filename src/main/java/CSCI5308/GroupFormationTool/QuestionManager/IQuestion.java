package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;

public interface IQuestion {
	public ArrayList<Answer> getAnswerList();

	public void setAnswerList(ArrayList<Answer> answerList);

	public int getQuestionId();

	public void setQuestionId(int questionId);

	public String getQuestionTitle();

	public void setQuestionTitle(String questionTitle);

	public String getQuestionText();

	public void setQuestionText(String questionText);

	public String getQuestionType();

	public void setQuestionType(String questionType);

	public String getQuestionDate();

	public void setQuestionDate(String questionDate);

	public int getQuestionNo();

	public void setQuestionNo(int questionNo);

	public String getCriteria();

	public void setCriteria(String criteria);

	public int getCourseId();

	public void setCourseId(int courseId);
}
