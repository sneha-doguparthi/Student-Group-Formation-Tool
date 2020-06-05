package com.asdc.group6.CourseAdmin.DAO;

import java.util.ArrayList;
import com.asdc.group6.Models.CourseAssociation;


public interface CourseAssociationDAO {

	public ArrayList<Integer> getUserID(Integer courseId);
	public boolean addByUserID(ArrayList<Integer> userIds, Integer courseId);
	Boolean insert(CourseAssociation association);
	ArrayList<CourseAssociation> getByUserId(Integer userId);
}
