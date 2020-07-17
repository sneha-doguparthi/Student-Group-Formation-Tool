package CSCI5308.GroupFormationTool.QuestionManager.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

public class IStoreQuestionServiceTest {
	IStoreQuestionService storeQuestionService = mock(StoreQuestionServiceImpl.class);
	IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
	int questionId = 123;

	public IStoreQuestionServiceTest() {
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
