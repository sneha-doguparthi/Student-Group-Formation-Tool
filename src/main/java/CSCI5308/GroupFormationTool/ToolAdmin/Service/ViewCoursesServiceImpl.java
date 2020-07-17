package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.IViewCourses;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ToolAdminDaoFactory;

public class ViewCoursesServiceImpl implements IViewCoursesService {

	@Override
	public ArrayList<ICourse> getCourseList() {
		IViewCourses viewCourses = ToolAdminDaoFactory.instance().viewCoursesDao();
		ArrayList<ICourse> courseList = viewCourses.getCourseList();
		return courseList;
	}
}