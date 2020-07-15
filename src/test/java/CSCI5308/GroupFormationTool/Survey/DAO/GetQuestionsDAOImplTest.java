package CSCI5308.GroupFormationTool.Survey.DAO;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetQuestionsDAOImplTest {
    IGetQuestionsDAO getQuestionsDAOImplMock = mock(GetQuestionsDAOImpl.class);
    @Test
    void getQuestionByInstructorId() {
        ArrayList<IQuestion> list = new ArrayList<>();
        IQuestion question= QuestionFactory.questionObject(new QuestionObjectFactory());
        question.setQuestionId(10);
        question.setCourseId(18);
        question.setCriteria("similar");
        list.add(question);
        when(getQuestionsDAOImplMock.getQuestionByInstructorId()).thenReturn(list);
        assertEquals(getQuestionsDAOImplMock.getQuestionByInstructorId(),list,"Error in getting questions list");
        verify(getQuestionsDAOImplMock).getQuestionByInstructorId();
    }

    @Test
    void getQuestionById() {
        IQuestion question= QuestionFactory.questionObject(new QuestionObjectFactory());
        question.setQuestionId(10);
        question.setCourseId(18);
        question.setCriteria("similar");

        when(getQuestionsDAOImplMock.getQuestionById(10)).thenReturn(question);
        assertEquals(getQuestionsDAOImplMock.getQuestionById(10), question, "Error getting question data");
        verify(getQuestionsDAOImplMock ).getQuestionById(10);
    }
}