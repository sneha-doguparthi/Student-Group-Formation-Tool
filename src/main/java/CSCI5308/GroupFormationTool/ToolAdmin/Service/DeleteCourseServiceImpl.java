package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.DeleteCourse;

public class DeleteCourseServiceImpl implements DeleteCourseService {

	@Override
	public ArrayList<String> deleteCourse(ArrayList<String> courseToDelete) {

		DeleteCourse deleteCourse = SystemConfig.instance().getDeleteCourse();

		ArrayList<String> courseList = deleteCourse.deleteCourse(courseToDelete);

		return courseList;
	}

}