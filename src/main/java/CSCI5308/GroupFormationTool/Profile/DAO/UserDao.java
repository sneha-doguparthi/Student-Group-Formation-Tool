package CSCI5308.GroupFormationTool.Profile.DAO;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Model.Student;

public interface UserDao {

	public ArrayList<User> getAll();

	public ArrayList<User> getUserByUserID(ArrayList<Integer> userIds);

	public ArrayList<Integer> getUserID(List<Student> students);

	public boolean addUser(List<Student> newToPortalList);

	public ArrayList<String> getPassword(List<Student> students);

	ArrayList<User> getByEmail(String email);

	Boolean update(User user);

	public boolean checkAccess(User user);

	public boolean registerUser(User u);
}
