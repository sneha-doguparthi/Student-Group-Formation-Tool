package CSCI5308.GroupFormationTool.Survey.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

class SaveSurveyServiceImplTest {
	ISaveSurveyService saveSurveyServiceMock = mock(SaveSurveyServiceImpl.class);

	@Test
	void splitQuestionDetails() {
		ArrayList<IQuestion> list = new ArrayList<>();
		String questionDetails = "31,similar";
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setCriteria("similar");
		question.setCourseId(12);
		question.setQuestionId(10);
		list.add(question);
		when(saveSurveyServiceMock.splitQuestionDetails(questionDetails)).thenReturn(list);
		assertEquals(saveSurveyServiceMock.splitQuestionDetails(questionDetails), list,
				"Error in getting question details list");
		verify(saveSurveyServiceMock).splitQuestionDetails(questionDetails);
	}

	@Test
	void saveSurveyQuestions() {
		ArrayList<IQuestion> list = new ArrayList<>();
		int course_id = 10;
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionId(10);
		question.setCourseId(12);
		question.setCriteria("similar");

		list.add(question);
		when(saveSurveyServiceMock.saveSurveyQuestions(list, course_id)).thenReturn(true);
		assertTrue(saveSurveyServiceMock.saveSurveyQuestions(list, course_id), "Error");
		verify(saveSurveyServiceMock).saveSurveyQuestions(list, course_id);
	}

	@Test
	void updateSurveyStatus() {
		int course_id = 10;

		when(saveSurveyServiceMock.updateSurveyStatus(course_id)).thenReturn(true);
		assertTrue(saveSurveyServiceMock.updateSurveyStatus(course_id), "error");
		verify(saveSurveyServiceMock).updateSurveyStatus(course_id);
	}
}