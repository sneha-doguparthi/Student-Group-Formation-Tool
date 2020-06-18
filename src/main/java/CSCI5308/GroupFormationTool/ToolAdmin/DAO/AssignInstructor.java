package CSCI5308.GroupFormationTool.ToolAdmin.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.User;

public interface AssignInstructor {

	public ArrayList<User> getUserList();
	public String assignRoleToUser(User user, String courseCode);
	public boolean checkIfCourseExistsForUser(User user, String course);

}
