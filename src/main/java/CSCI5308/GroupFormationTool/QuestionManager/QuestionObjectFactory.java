package CSCI5308.GroupFormationTool.QuestionManager;

public class QuestionObjectFactory extends QuestionAbstractFactory {

	@Override
	public IQuestion questionObject() {
		return new Question();
	}

}
