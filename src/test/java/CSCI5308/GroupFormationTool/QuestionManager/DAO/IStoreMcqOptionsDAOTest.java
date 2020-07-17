package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class IStoreMcqOptionsDAOTest {
	IStoreMcqOptionsDAO storeMcqOptionsDAO = mock(StoreMcqOptionsDAOImpl.class);
	ArrayList<Answer> answerList = new ArrayList<>();
	int questionId = 123;

	public IStoreMcqOptionsDAOTest() {
		Answer answer = new Answer();
		answer.setAnswerText("Beginner");
		answer.setStoredAs("1");

		answer = new Answer();
		answer.setAnswerText("Expert");
		answer.setStoredAs("2");
	}

	@Test
	public void testStoreMcqOptionsForQuestion() {
		when(storeMcqOptionsDAO.saveMcqOptionsForQuestion(questionId, answerList))
				.thenReturn(ApplicationConstants.QUESTION_ANSWERS_ADDED);

		assertEquals(storeMcqOptionsDAO.saveMcqOptionsForQuestion(questionId, answerList),
				ApplicationConstants.QUESTION_ANSWERS_ADDED);
		verify(storeMcqOptionsDAO).saveMcqOptionsForQuestion(questionId, answerList);
	}
}
