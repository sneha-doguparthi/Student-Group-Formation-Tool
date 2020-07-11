package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Profile.IUser;

public interface IGetStudentListService {

	public List<Student> getNewToPortalStudentList(List<Student> students, ArrayList<IUser> users);

	public List<Student> getNewToCourseStudentList(List<Student> students, ArrayList<IUser> users);

}
