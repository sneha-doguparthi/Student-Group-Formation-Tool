package CSCI5308.GroupFormationTool.QuestionManager.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.Question;

public class DeleteQuestionServiceTest {

	DeleteQuestionService deleteQuestionService = mock(DeleteQuestionServiceImpl.class);

	@Test
	public void testDeleteQuestionAndOptions() {

		int questionId = 7;

		Question question = new Question();
		question.setQuestionId(7);
		question.setQuestionTitle("This is the question title");
		question.setQuestionText("This is the question text");
		question.setQuestionType("This is the question type");
		question.setQuestionDate("12/12/12");

		when(deleteQuestionService.deleteQuestionAndOptions(questionId)).thenReturn(true);
		assertTrue(deleteQuestionService.deleteQuestionAndOptions(questionId), "deleteQuestionAndOptions Test Failed");
		verify(deleteQuestionService).deleteQuestionAndOptions(questionId);
	}

}
