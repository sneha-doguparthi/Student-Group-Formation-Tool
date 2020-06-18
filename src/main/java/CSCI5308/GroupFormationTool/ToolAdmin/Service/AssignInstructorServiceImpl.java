package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.AssignInstructor;

public class AssignInstructorServiceImpl implements AssignInstructorService {

	AssignInstructor assignInstructor;

	@Override
	public ArrayList<User> getUserList() {

		assignInstructor = SystemConfig.instance().getAssignInstructor();

		return assignInstructor.getUserList();
	}

	@Override
	public String assignRoleToUser(User user, String courseCode) {

		if (null != getCourseCodeFromString(courseCode)) {
			assignInstructor = SystemConfig.instance().getAssignInstructor();
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