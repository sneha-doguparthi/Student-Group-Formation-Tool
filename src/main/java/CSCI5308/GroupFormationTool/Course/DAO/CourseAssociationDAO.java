package CSCI5308.GroupFormationTool.Course.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.CourseAssociation;

public interface CourseAssociationDAO {

	public ArrayList<Integer> getUserID(Integer courseId);

	public boolean addByUserID(ArrayList<Integer> userIds, Integer courseId);

	Boolean insert(CourseAssociation association);

	ArrayList<CourseAssociation> getByUserId(Integer userId);
}
