package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Profile.IUser;

public interface IAssignInstructor {

	public ArrayList<IUser> getUserList();

	public String assignRoleToUser(IUser user, String courseCode);

	public boolean checkIfCourseExistsForUser(IUser user, String course);

}
