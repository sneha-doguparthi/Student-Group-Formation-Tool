package CSCI5308.GroupFormationTool.Course.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Model.SurveyResponse;

class CourseSurveyDaoImplTest {
    ICourseSurveyDao courseSurveyDaoMock = mock(CourseSurveyDaoImpl.class);
    @Test
    void storeSurveyResponse() {
        ArrayList<SurveyResponse> list= new ArrayList<>();
        SurveyResponse surveyResponse = new SurveyResponse();
        surveyResponse.setCourseId(12);
        surveyResponse.setAnswer("answer");
        surveyResponse.setQuestionId(13);
        surveyResponse.setUserId(89);

        String response= "stored";

        when(courseSurveyDaoMock.storeSurveyResponse(list)).thenReturn(response);
        assertEquals(courseSurveyDaoMock.storeSurveyResponse(list),response,"Error");
        verify(courseSurveyDaoMock).storeSurveyResponse(list);
    }

    @Test
    void checkIfSurveySubmitted() {
        int courseId = 20;
        int userId=14;
        when(courseSurveyDaoMock.checkIfSurveySubmitted(courseId,userId)).thenReturn(true);
        assertEquals(courseSurveyDaoMock.checkIfSurveySubmitted(courseId,userId),true,"Error");
        verify(courseSurveyDaoMock).checkIfSurveySubmitted(courseId,userId);
    }
}