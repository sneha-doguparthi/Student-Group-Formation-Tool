package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import CSCI5308.GroupFormationTool.Course.Course;

public interface IAddCourse {

	public String addNewCourse(Course course);

	public boolean checkIfCourseExists(Course course);

}
