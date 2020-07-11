package CSCI5308.GroupFormationTool.QuestionManager.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Answer;

public class ISplitMcqAnswerServiceTest {
	ISplitMcqAnswerService splitMcqAnswerService = mock(SplitMcqAnswerServiceImpl.class);
	ArrayList<Answer> answerList = new ArrayList<>();
	Answer answer = new Answer();
	int questionId = 123;

	public ISplitMcqAnswerServiceTest() {
		Answer answer = new Answer();
		answer.setAnswerText("Beginner");
		answer.setStoredAs("1");
		answerList.add(answer);
		answer = new Answer();
		answer.setAnswerText("Expert");
		answer.setStoredAs("2");
		answerList.add(answer);

		answer.setAnswerText("Beginner,Expert");
		answer.setStoredAs("1,2");
	}

	@Test
	public void testStoreMcqOptionsForQuestion() {
		when(splitMcqAnswerService.splitMcqAnswers(answer)).thenReturn(answerList);
		assertEquals(splitMcqAnswerService.splitMcqAnswers(answer), answerList);
		verify(splitMcqAnswerService).splitMcqAnswers(answer);
	}
}
