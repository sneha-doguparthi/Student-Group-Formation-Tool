package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Profile.IUser;

public interface IAssignInstructorService {

	public ArrayList<IUser> getUserList();

	public String assignRoleToUser(IUser user, String courseCode);

	public String getCourseCodeFromString(String courseCode);

}