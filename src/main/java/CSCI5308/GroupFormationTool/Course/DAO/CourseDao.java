package CSCI5308.GroupFormationTool.Course.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Course;

public interface CourseDao {

	ArrayList<Course> getAll();

	Course getById(Integer id);
}
