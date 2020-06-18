package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ViewCourses;

public class ViewCoursesServiceImpl implements ViewCoursesService {

	@Override
	public ArrayList<Course> getCourseList() {

		ViewCourses viewCourses = SystemConfig.instance().getViewCourses();

		ArrayList<Course> courseList = viewCourses.getCourseList();

		return courseList;
	}
}