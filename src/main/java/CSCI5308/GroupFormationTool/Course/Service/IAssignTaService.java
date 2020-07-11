package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.User;

public interface IAssignTaService {

	public ArrayList<User> getAllUsers();

	public Boolean assignTa(String userId, Integer courseId);
}
