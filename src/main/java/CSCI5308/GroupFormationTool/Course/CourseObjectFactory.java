package CSCI5308.GroupFormationTool.Course;

public class CourseObjectFactory extends CourseAbstractFactory {

	@Override
	public ICourse courseObject() {
		return new Course();
	}

}
