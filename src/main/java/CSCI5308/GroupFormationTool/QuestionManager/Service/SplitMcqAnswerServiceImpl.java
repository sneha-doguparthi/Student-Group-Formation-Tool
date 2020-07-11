package CSCI5308.GroupFormationTool.QuestionManager.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Answer;

public class SplitMcqAnswerServiceImpl implements ISplitMcqAnswerService {

	@Override
	public ArrayList<Answer> splitMcqAnswers(Answer answerInfo) {

		ArrayList<Answer> answerList = new ArrayList<>();
		String answerText = answerInfo.getAnswerText();
		String storedAs = answerInfo.getStoredAs();
		String[] answerTextList = answerText.split(",");
		String[] storedAsList = storedAs.split(",");

		for (int i = 0; i < answerTextList.length; i++) {
			Answer answer = new Answer();
			answer.setAnswerText(answerTextList[i].trim());
			answer.setStoredAs(storedAsList[i].trim());
			answerList.add(answer);
		}
		return answerList;
	}
}
