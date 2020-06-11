package CSCI5308.GroupFormationTool.CourseAdmin.Service;

import java.util.ArrayList;
import CSCI5308.GroupFormationTool.Model.User;

public interface AssignTaService {

	ArrayList<User> getAllUsers();

	Boolean assignTa(String userId, Integer courseId);
}
