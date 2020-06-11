package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AssignInstructor;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AssignInstructorImpl;

public class AssignInstructorServiceImpl implements AssignInstructorService {

	@Override
	public ArrayList<User> getUserList() {
		AssignInstructor assignInstructor = new AssignInstructorImpl();
		return assignInstructor.getUserList();
	}

	@Override
	public String assignRoleToUser(User user, String courseCode) {
		if (null != getCourseCodeFromString(courseCode)) {
			AssignInstructor assignInstructor = new AssignInstructorImpl();
			return assignInstructor.assignRoleToUser(user, getCourseCodeFromString(courseCode));
		}
		return null;
	}

	@Override
	public String getCourseCodeFromString(String courseCode) {
		if (null != courseCode) {
			return courseCode.split(" - ")[0];
		}
		return null;
	}

}