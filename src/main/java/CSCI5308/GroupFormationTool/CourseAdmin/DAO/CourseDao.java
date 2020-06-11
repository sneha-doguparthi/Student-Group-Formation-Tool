package CSCI5308.GroupFormationTool.CourseAdmin.DAO;

import CSCI5308.GroupFormationTool.Model.Course;

import java.util.ArrayList;

public interface CourseDao {

	ArrayList<Course> getAll();

	Course getById(Integer id);
}
