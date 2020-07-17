package CSCI5308.GroupFormationTool.Course.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;

class CourseSurveyServiceImplTest {
    ICourseSurveyService courseSurveyServiceMock = mock(CourseSurveyServiceImpl.class);
    @Test
    void validateResponses() {
        IQuestion question= QuestionFactory.questionObject(new QuestionObjectFactory());
        question.setQuestionId(10);
        question.setCourseId(18);
        question.setCriteria("similar");
        ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
        survey.setCourseId(18);
        survey.setGroupSize(5);
        survey.setSurveyStatus("A");

        when(courseSurveyServiceMock.validateResponses(question,survey)).thenReturn(true);
        assertEquals(courseSurveyServiceMock.validateResponses(question,survey),true,"Error in validating");
        verify(courseSurveyServiceMock).validateResponses(question,survey);
    }

    @Test
    void splitSurveyResponse() {
        IQuestion question= QuestionFactory.questionObject(new QuestionObjectFactory());
        question.setQuestionId(10);
        question.setCourseId(18);
        question.setCriteria("similar");
        ArrayList<SurveyResponse> list= new ArrayList<>();
        SurveyResponse surveyResponse = new SurveyResponse();
        surveyResponse.setCourseId(18);
        surveyResponse.setAnswer("answer");
        surveyResponse.setQuestionId(10);
        surveyResponse.setUserId(89);
        list.add(surveyResponse);
        when(courseSurveyServiceMock.splitSurveyResponse(question)).thenReturn(list);
        assertEquals(courseSurveyServiceMock.splitSurveyResponse(question),list,"Error in splitting");
        verify(courseSurveyServiceMock).splitSurveyResponse(question);

    }

    @Test
    void storeSurveyResponse() {
        ArrayList<SurveyResponse> list= new ArrayList<>();
        SurveyResponse surveyResponse = new SurveyResponse();
        surveyResponse.setCourseId(12);
        surveyResponse.setAnswer("answer");
        surveyResponse.setQuestionId(13);
        surveyResponse.setUserId(89);
        list.add(surveyResponse);

        String response= "stored";

        when(courseSurveyServiceMock.storeSurveyResponse(list)).thenReturn(response);
        assertEquals(courseSurveyServiceMock.storeSurveyResponse(list),response,"Error");
        verify(courseSurveyServiceMock).storeSurveyResponse(list);
    }

    @Test
    void checkIfSurveySubmitted() {
        int courseId = 20;
        int userId=14;
        when(courseSurveyServiceMock.checkIfSurveySubmitted(courseId,userId)).thenReturn(true);
        assertEquals(courseSurveyServiceMock.checkIfSurveySubmitted(courseId,userId),true,"Error");
        verify(courseSurveyServiceMock).checkIfSurveySubmitted(courseId,userId);
    }
}