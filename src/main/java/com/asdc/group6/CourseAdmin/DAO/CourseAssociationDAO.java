package com.asdc.group6.CourseAdmin.DAO;

import java.util.ArrayList;

public interface CourseAssociationDAO {

	public ArrayList<Integer> getUserID(Integer courseId);
	public boolean addByUserID(ArrayList<Integer> userIds, Integer courseId);

}
