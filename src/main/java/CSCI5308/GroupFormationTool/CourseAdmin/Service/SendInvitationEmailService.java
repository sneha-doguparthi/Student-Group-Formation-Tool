package CSCI5308.GroupFormationTool.CourseAdmin.Service;

import java.util.List;
import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Student;

public interface SendInvitationEmailService {

	public boolean sendCourseInvitationEmail(List<Student> newToCourseList, String courseCode, String courseName);

	public boolean sendUserInvitationEmail(List<Student> newToPortalList, ArrayList<String> passwords);

}
