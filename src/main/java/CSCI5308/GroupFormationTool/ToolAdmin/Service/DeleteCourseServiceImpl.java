package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.ToolAdmin.DAO.IDeleteCourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ToolAdminDaoFactory;

public class DeleteCourseServiceImpl implements IDeleteCourseService {

	@Override
	public ArrayList<String> deleteCourse(ArrayList<String> courseToDelete) {
		IDeleteCourse deleteCourse = ToolAdminDaoFactory.instance().deleteCourseDao();
		ArrayList<String> courseList = deleteCourse.deleteCourse(courseToDelete);
		return courseList;
	}

}