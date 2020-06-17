package CSCI5308.GroupFormationTool.QuestionManager.DAO;

import static org.junit.jupiter.api.Assertions.*;
import CSCI5308.GroupFormationTool.Model.Question;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.mockito.Mockito.*;

class QuestionManagerDaoImplTest {
    QuestionManagerDao questionManagerDao = mock(QuestionManagerDaoImpl.class);

    @Test
    void testInsertQuestion() {
        Question question = new Question();
        question.setTitle("credit hours");
        question.setQuestion("How many hours are you attempting?");
        question.setType("Numeric");
        question.setDate(Date.valueOf("2020-06-13"));

        when(questionManagerDao.insertQuestion(question)).thenReturn(true);
        assertTrue(questionManagerDao.insertQuestion(question), "Error in creating question");
        verify(questionManagerDao).insertQuestion(question);
    }
}