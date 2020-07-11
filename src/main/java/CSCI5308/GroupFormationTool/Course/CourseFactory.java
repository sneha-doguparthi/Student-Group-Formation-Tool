package CSCI5308.GroupFormationTool.Course;

public class CourseFactory {

	public static ICourse courseObject(CourseAbstractFactory courseAbstractFactory) {
		return courseAbstractFactory.courseObject();
	}

}
