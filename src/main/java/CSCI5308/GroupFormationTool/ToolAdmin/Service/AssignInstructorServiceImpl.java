package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.IAssignInstructor;
import CSCI5308.GroupFormationTool.ToolAdmin.DAO.ToolAdminDaoFactory;

public class AssignInstructorServiceImpl implements IAssignInstructorService {

	IAssignInstructor assignInstructor;

	@Override
	public ArrayList<IUser> getUserList() {
		assignInstructor = ToolAdminDaoFactory.instance().assignInstructorDao();
		return assignInstructor.getUserList();
	}

	@Override
	public String assignRoleToUser(IUser user, String courseCode) {
		if (null != getCourseCodeFromString(courseCode)) {
			assignInstructor = ToolAdminDaoFactory.instance().assignInstructorDao();
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