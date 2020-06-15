package CSCI5308.GroupFormationTool.Model;

import org.junit.jupiter.api.Test;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class QuestionModelTest {

    @Test
    void getTitle() {
        Question question = new Question();
        question.setTitle("credit hours");
        assertEquals(question.getTitle(),"credit hours");
    }

    @Test
    void setTitle() {
        Question question = new Question();
        question.setTitle("credit hours");
        assertEquals(question.getTitle(),"credit hours");
    }

    @Test
    void getQuestion() {
        Question question = new Question();
        question.setQuestion("How many hours are you attempting?");
        assertEquals(question.getQuestion(),"How many hours are you attempting?");
    }

    @Test
    void setQuestion() {
        Question question = new Question();
        question.setQuestion("How many hours are you attempting?");
        assertEquals(question.getQuestion(),"How many hours are you attempting?");
    }

    @Test
    void getType() {
        Question question = new Question();
        question.setType("Numeric");
        assertEquals(question.getType(),"Numeric");
    }

    @Test
    void setType() {
        Question question = new Question();
        question.setType("Numeric");
        assertEquals(question.getType(),"Numeric");
    }

    @Test
    void getDate() {
        Question question = new Question();
        question.setDate(Date.valueOf("2020-06-13"));
        assertEquals(question.getDate(),Date.valueOf("2020-06-13"));
    }

    @Test
    void setDate() {
        Question question = new Question();
        question.setDate(Date.valueOf("2020-06-13"));
        assertEquals(question.getDate(),Date.valueOf("2020-06-13"));
    }
}