package CSCI5308.GroupFormationTool.QuestionManager;

public class QuestionFactory {
	public static IQuestion questionObject(QuestionAbstractFactory questionAbstractFactory) {
		return questionAbstractFactory.questionObject();
	}
}
