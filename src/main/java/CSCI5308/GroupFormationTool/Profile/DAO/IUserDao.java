package CSCI5308.GroupFormationTool.Profile.DAO;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Model.User;

public interface IUserDao {

	public ArrayList<User> getAll();

	public ArrayList<User> getUserByUserID(ArrayList<Integer> userIds);

	public ArrayList<Integer> getUserID(List<Student> students);

	public boolean addUser(List<Student> newToPortalList);

	public ArrayList<String> getPassword(List<Student> students);

	public ArrayList<User> getByEmail(String email);

	public Boolean update(User user);

	public boolean checkAccess(User user);

	public boolean registerUser(User u);
}
