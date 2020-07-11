package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

public class IFetchQuestionDAOTest {

	IFetchQuestionDAO fetchQuestionDAO = mock(FetchQuestionDAOImpl.class);

	@Test
	public void testGetQuestionByUserId() {
		ArrayList<IQuestion> result = new ArrayList<>();

		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionNo(1);
		question.setQuestionId(5);
		question.setQuestionTitle("This is the question title");
		question.setQuestionText("This is the question text");
		question.setQuestionType("This is the question type");
		question.setQuestionDate("12/12/12");
		result.add(question);

		when(fetchQuestionDAO.getQuestionByUserId()).thenReturn(result);
		assertEquals(fetchQuestionDAO.getQuestionByUserId(), result);
		verify(fetchQuestionDAO).getQuestionByUserId();
	}
}
