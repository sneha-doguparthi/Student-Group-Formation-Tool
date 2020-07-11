package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Model.Student;

public interface ISendInvitationEmailService {

	public boolean sendCourseInvitationEmail(List<Student> newToCourseList, String courseCode, String courseName);

	public boolean sendUserInvitationEmail(List<Student> newToPortalList, ArrayList<String> passwords);

}
