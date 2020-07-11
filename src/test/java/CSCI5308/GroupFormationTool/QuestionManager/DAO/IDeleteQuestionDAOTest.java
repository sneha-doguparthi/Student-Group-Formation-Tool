package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

public class IDeleteQuestionDAOTest {

	IDeleteQuestionDAO deleteQuestionDAO = mock(DeleteQuestionDAOImpl.class);

	@Test
	public void testDeleteQuestionByQuestionId() {

		int questionId = 7;

		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionId(7);
		question.setQuestionTitle("This is the question title");
		question.setQuestionText("This is the question text");
		question.setQuestionType("This is the question type");
		question.setQuestionDate("12/12/12");

		when(deleteQuestionDAO.deleteQuestionByQuestionId(questionId)).thenReturn(true);
		assertTrue(deleteQuestionDAO.deleteQuestionByQuestionId(questionId), "deleteQuestionByQuestionId Test Failed");
		verify(deleteQuestionDAO).deleteQuestionByQuestionId(questionId);
	}

}
