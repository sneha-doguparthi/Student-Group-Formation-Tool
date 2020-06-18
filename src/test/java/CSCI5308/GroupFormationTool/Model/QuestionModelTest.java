package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class QuestionModelTest {
	@Test
	void getTitle() {
		Question question = new Question();
		question.setQuestionTitle("credit hours");
		assertEquals(question.getQuestionTitle(), "credit hours");
	}

	@Test
	void setTitle() {
		Question question = new Question();
		question.setQuestionTitle("credit hours");
		assertEquals(question.getQuestionTitle(), "credit hours");
	}

	@Test
	void getQuestion() {
		Question question = new Question();
		question.setQuestionText("How many hours are you attempting?");
		assertEquals(question.getQuestionText(), "How many hours are you attempting?");
	}

	@Test
	void setQuestion() {
		Question question = new Question();
		question.setQuestionText("How many hours are you attempting?");
		assertEquals(question.getQuestionText(), "How many hours are you attempting?");
	}

	@Test
	void getType() {
		Question question = new Question();
		question.setQuestionType("NUM");
		assertEquals(question.getQuestionType(), "NUM");
	}

	@Test
	void setType() {
		Question question = new Question();
		question.setQuestionType("NUM");
		assertEquals(question.getQuestionType(), "NUM");
	}
}