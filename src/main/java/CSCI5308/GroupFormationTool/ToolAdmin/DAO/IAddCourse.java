package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import CSCI5308.GroupFormationTool.Course.ICourse;

public interface IAddCourse {

	public String addNewCourse(ICourse course);

	public boolean checkIfCourseExists(ICourse course);

}
