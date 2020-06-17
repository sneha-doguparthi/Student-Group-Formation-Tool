package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AddCourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AddCourseImpl;

public class AddCourseServiceImpl implements AddCourseService {

	@Override
	public String addNewCourse(Course course) {
		AddCourse addCourse = new AddCourseImpl();
		return addCourse.addNewCourse(course);
	}

}