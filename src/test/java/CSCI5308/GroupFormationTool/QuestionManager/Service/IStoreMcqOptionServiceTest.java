package CSCI5308.GroupFormationTool.QuestionManager.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Answer;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class IStoreMcqOptionServiceTest {
	IStoreMcqOptionService storeMcqOptionService = mock(StoreMcqOptionServiceImpl.class);
	ArrayList<Answer> answerList = new ArrayList<>();
	int questionId = 123;

	public IStoreMcqOptionServiceTest() {
		Answer answer = new Answer();
		answer.setAnswerText("Beginner");
		answer.setStoredAs("1");

		answer = new Answer();
		answer.setAnswerText("Expert");
		answer.setStoredAs("2");
	}

	@Test
	public void testStoreMcqOptionsForQuestion() {
		when(storeMcqOptionService.saveMcqOptionsForQuestion(questionId, answerList))
				.thenReturn(ApplicationConstants.QUESTION_ANSWERS_ADDED);

		assertEquals(storeMcqOptionService.saveMcqOptionsForQuestion(questionId, answerList),
				ApplicationConstants.QUESTION_ANSWERS_ADDED);
		verify(storeMcqOptionService).saveMcqOptionsForQuestion(questionId, answerList);
	}
}
