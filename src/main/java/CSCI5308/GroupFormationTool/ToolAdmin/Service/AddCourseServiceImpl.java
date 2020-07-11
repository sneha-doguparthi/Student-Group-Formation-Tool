package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.IAddCourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ToolAdminDaoFactory;

public class AddCourseServiceImpl implements IAddCourseService {

	@Override
	public String addNewCourse(ICourse course) {
		IAddCourse addCourse = ToolAdminDaoFactory.instance().addCourseDao();
		return addCourse.addNewCourse(course);
	}

}