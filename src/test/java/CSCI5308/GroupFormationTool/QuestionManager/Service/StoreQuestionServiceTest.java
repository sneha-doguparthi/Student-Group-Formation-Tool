package CSCI5308.GroupFormationTool.QuestionManager.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Question;

public class StoreQuestionServiceTest {
	StoreQuestionService storeQuestionService = mock(StoreQuestionServiceImpl.class);
	Question question = new Question();
	int questionId = 123;

	public StoreQuestionServiceTest() {
		question.setQuestionTitle("Java");
		question.setQuestionText("How many hours are you attempting?");
		question.setQuestionType("NUM");
	}

	@Test
	public void testSaveQuestionDetails() {
		when(storeQuestionService.saveQuestionDetails(question)).thenReturn(questionId);

		assertEquals(storeQuestionService.saveQuestionDetails(question), questionId);
		verify(storeQuestionService).saveQuestionDetails(question);
	}
}
