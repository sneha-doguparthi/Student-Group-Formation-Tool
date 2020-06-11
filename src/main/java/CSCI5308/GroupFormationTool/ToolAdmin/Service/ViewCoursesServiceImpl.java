package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ViewCourses;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ViewCoursesImpl;

public class ViewCoursesServiceImpl implements ViewCoursesService {
	@Override
	public ArrayList<Course> getCourseList() {
		ViewCourses viewCourses = new ViewCoursesImpl();
		ArrayList<Course> courseList = viewCourses.getCourseList();
		return courseList;
	}
}