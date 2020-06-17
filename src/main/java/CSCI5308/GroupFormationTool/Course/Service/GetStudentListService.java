package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Model.User;

public interface GetStudentListService {

	public List<Student> getNewToPortalStudentList(List<Student> students, ArrayList<User> users);

	public List<Student> getNewToCourseStudentList(List<Student> students, ArrayList<User> users);

}
