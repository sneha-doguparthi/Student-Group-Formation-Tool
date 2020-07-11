package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Profile.IUser;

public interface IAssignTaService {

	public ArrayList<IUser> getAllUsers();

	public Boolean assignTa(String userId, Integer courseId);
}
