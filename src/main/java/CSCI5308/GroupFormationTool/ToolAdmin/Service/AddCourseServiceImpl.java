package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import CSCI5308.GroupFormationTool.Course.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.IAddCourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ToolAdminDaoFactory;

public class AddCourseServiceImpl implements IAddCourseService {

	@Override
	public String addNewCourse(Course course) {
		IAddCourse addCourse = ToolAdminDaoFactory.instance().addCourseDao();
		return addCourse.addNewCourse(course);
	}

}