package CSCI5308.GroupFormationTool.Course.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.CourseAssociation;

public interface ICourseAssociationDao {

	public ArrayList<Integer> getUserID(Integer courseId);

	public boolean addByUserID(ArrayList<Integer> userIds, Integer courseId);

	public Boolean insert(CourseAssociation association);

	public ArrayList<CourseAssociation> getByUserId(Integer userId);
}
