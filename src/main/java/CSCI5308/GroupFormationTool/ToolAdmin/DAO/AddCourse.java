package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import CSCI5308.GroupFormationTool.Model.Course;

public interface AddCourse {

	public String addNewCourse(Course course);

	public boolean checkIfCourseExists(Course course);

}
