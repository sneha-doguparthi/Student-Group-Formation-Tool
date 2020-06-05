package com.asdc.group6.CourseAdmin.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Student;
import com.asdc.group6.Models.User;

@Component
public class GetStudentListServiceImpl implements GetStudentListService {

	@Override
	public List<Student> getNewToCourseStudentList(List<Student> studentsFromCsv, ArrayList<User> specificUserList) {

		List<Student> students = new ArrayList<Student>(studentsFromCsv);
		List<User> users = new ArrayList<User>(specificUserList);

		int studentsSize = students.size();
		int usersSize = users.size();

		for (int i = 0; i < usersSize; i++) {
			for (int j = 0; j < studentsSize; j++) {
				if (students.get(j).getbId().equals(users.get(i).getBannerId())) {
					students.remove(j);
					studentsSize--;
					break;
				}
			}
		}

		return students;
	}

	@Override
	public List<Student> getNewToPortalStudentList(List<Student> newToCourseList, ArrayList<User> allUserList) {

		List<Student> students = new ArrayList<Student>(newToCourseList);
		List<User> users = new ArrayList<User>(allUserList);

		int studentsSize = students.size();
		int usersSize = users.size();

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.createConnection();
			for (int i = 0; i < usersSize; i++) {
				for (int j = 0; j < studentsSize; j++) {
//					System.out.println("j=" + students.get(j).getbId());
					if (students.get(j).getbId().equals(users.get(i).getBannerId())) {
						String reqQuery = "UPDATE user SET user_type='S' WHERE banner_id=?";
						statement = connection.prepareStatement(reqQuery);
						statement.setString(1, users.get(i).getBannerId());
						statement.executeUpdate();

						students.remove(j);
						studentsSize--;
						break;
					}
//					System.out.println("Inside New to Portal-2: " + studentsSize);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

//		System.out.println("Inside New to Portal-1: " + studentsSize);
		return students;
	}

}
