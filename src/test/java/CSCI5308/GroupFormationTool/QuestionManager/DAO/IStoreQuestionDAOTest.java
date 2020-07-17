package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

public class IStoreQuestionDAOTest {
	IStoreQuestionDAO storeQuestionDAO = mock(StoreQuestionDAOImpl.class);
	IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
	int questionId = 123;

	public IStoreQuestionDAOTest() {
		question.setQuestionTitle("Java");
		question.setQuestionText("How many hours are you attempting?");
		question.setQuestionType("NUM");
	}

	@Test
	public void testSaveQuestionDetails() {
		when(storeQuestionDAO.saveQuestionDetails(question)).thenReturn(questionId);

		assertEquals(storeQuestionDAO.saveQuestionDetails(question), questionId);
		verify(storeQuestionDAO).saveQuestionDetails(question);
	}
}
