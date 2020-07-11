package CSCI5308.GroupFormationTool.Profile.DAO;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Profile.IUser;

public interface IUserDao {

	public ArrayList<IUser> getAll();

	public ArrayList<IUser> getUserByUserID(ArrayList<Integer> userIds);

	public ArrayList<Integer> getUserID(List<Student> students);

	public boolean addUser(List<Student> newToPortalList);

	public ArrayList<String> getPassword(List<Student> students);

	public ArrayList<IUser> getByEmail(String email);

	public Boolean update(IUser user);

	public boolean checkAccess(IUser user);

	public boolean registerUser(IUser u);
}
