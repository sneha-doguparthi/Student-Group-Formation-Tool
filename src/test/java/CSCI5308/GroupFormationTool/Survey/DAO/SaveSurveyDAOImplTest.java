package CSCI5308.GroupFormationTool.Survey.DAO;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.SurveyFactory;
import CSCI5308.GroupFormationTool.Survey.SurveyObjectFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SaveSurveyDAOImplTest {
    ISaveSurveyDAO saveSurveyDAOMock = mock(SaveSurveyDAOImpl.class);

    @Test
    void saveSurveyQuestions() {
        ArrayList<IQuestion> list = new ArrayList<>();
        IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
        question.setQuestionId(10);
        question.setCourseId(12);
        question.setCriteria("similar");
        list.add(question);

        when(saveSurveyDAOMock.saveSurveyQuestions(list)).thenReturn(true);
        assertTrue(saveSurveyDAOMock.saveSurveyQuestions(list), "Error");
        verify(saveSurveyDAOMock).saveSurveyQuestions(list);

    }

    @Test
    void publishSurvey() {
        int course_id = 10;

        when(saveSurveyDAOMock.publishSurvey(course_id)).thenReturn(true);
        assertTrue(saveSurveyDAOMock.publishSurvey(course_id), "error");
        verify(saveSurveyDAOMock).publishSurvey(course_id);
    }
}