package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.User;

public interface AssignInstructorService {

	public ArrayList<User> getUserList();
	public String assignRoleToUser(User user, String courseCode);
	public String getCourseCodeFromString(String courseCode);

}