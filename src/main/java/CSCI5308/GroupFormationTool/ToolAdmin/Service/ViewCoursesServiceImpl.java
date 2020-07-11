package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Course.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.IViewCourses;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ToolAdminDaoFactory;

public class ViewCoursesServiceImpl implements IViewCoursesService {

	@Override
	public ArrayList<Course> getCourseList() {
		IViewCourses viewCourses = ToolAdminDaoFactory.instance().viewCoursesDao();
		ArrayList<Course> courseList = viewCourses.getCourseList();
		return courseList;
	}
}