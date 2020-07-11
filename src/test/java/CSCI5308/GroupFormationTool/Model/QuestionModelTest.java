package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionFactory;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionObjectFactory;

class QuestionModelTest {
	@Test
	void getTitle() {
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionTitle("credit hours");
		assertEquals(question.getQuestionTitle(), "credit hours");
	}

	@Test
	void setTitle() {
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionTitle("credit hours");
		assertEquals(question.getQuestionTitle(), "credit hours");
	}

	@Test
	void getQuestion() {
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionText("How many hours are you attempting?");
		assertEquals(question.getQuestionText(), "How many hours are you attempting?");
	}

	@Test
	void setQuestion() {
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionText("How many hours are you attempting?");
		assertEquals(question.getQuestionText(), "How many hours are you attempting?");
	}

	@Test
	void getType() {
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionType("NUM");
		assertEquals(question.getQuestionType(), "NUM");
	}

	@Test
	void setType() {
		IQuestion question = QuestionFactory.questionObject(new QuestionObjectFactory());
		question.setQuestionType("NUM");
		assertEquals(question.getQuestionType(), "NUM");
	}
}