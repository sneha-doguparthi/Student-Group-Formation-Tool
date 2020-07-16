package CSCI5308.GroupFormationTool.Survey.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;

class GetQuestionsServiceImplTest {
	IGetQuestionsService getQuestionsServiceMock = mock(GetQuestionsServiceImpl.class);

	@Test
	void getQuestionForInstructor() {
		ArrayList<IQuestion> list = new ArrayList<>();
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setCourseId(12);
		question.setCriteria("similar");
		question.setQuestionId(10);

		when(getQuestionsServiceMock.getQuestionForInstructor()).thenReturn(list);
		assertEquals(getQuestionsServiceMock.getQuestionForInstructor(), list, "Error in getting question list");
		verify(getQuestionsServiceMock).getQuestionForInstructor();

	}

	@Test
	void getOneQuestion() {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setGroupSize(3);
		survey.setCourseId(12);
		survey.setSurveyStatus("A");
		int questionId = 13;

		when(getQuestionsServiceMock.getOneQuestion(survey, questionId)).thenReturn(survey);
		assertEquals(getQuestionsServiceMock.getOneQuestion(survey, questionId), survey, "Error");
		verify(getQuestionsServiceMock).getOneQuestion(survey, questionId);

	}

	@Test
	void deleteQuestion() {
		ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
		survey.setGroupSize(3);
		survey.setCourseId(12);
		survey.setSurveyStatus("A");
		int questionId = 13;

		when(getQuestionsServiceMock.deleteQuestion(survey, questionId)).thenReturn(survey);
		assertEquals(getQuestionsServiceMock.deleteQuestion(survey, questionId), survey, "Error in getting survey");
		verify(getQuestionsServiceMock).deleteQuestion(survey, questionId);
	}
}