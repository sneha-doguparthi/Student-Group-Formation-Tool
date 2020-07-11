package CSCI5308.GroupFormationTool.Course.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Course.ICourse;

public interface ICourseDao {

	public ArrayList<ICourse> getAll();

	public ICourse getById(Integer id);
}
