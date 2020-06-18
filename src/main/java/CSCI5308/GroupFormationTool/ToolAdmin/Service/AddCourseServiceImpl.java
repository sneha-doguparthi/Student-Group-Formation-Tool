package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AddCourse;

public class AddCourseServiceImpl implements AddCourseService {

	@Override
	public String addNewCourse(Course course) {
		AddCourse addCourse = SystemConfig.instance().getAddCourse();
		return addCourse.addNewCourse(course);
	}

}