package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.ToolAdmin.DAO.DeleteCourse;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.DeleteCourseImpl;

public class DeleteCourseServiceImpl implements DeleteCourseService {

	@Override
	public ArrayList<String> deleteCourse(ArrayList<String> courseToDelete) {
		DeleteCourse deleteCourse = new DeleteCourseImpl();
		ArrayList<String> courseList = deleteCourse.deleteCourse(courseToDelete);
		return courseList;
	}

}