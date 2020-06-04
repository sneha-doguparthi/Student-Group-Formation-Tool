package com.asdc.group6.Profile.Login.DAO;

import java.util.ArrayList;
import com.asdc.group6.Models.Association;


public interface AssociationDao {

	Boolean insert(Association association);
	
	ArrayList<Association> getByUserId(Integer userId);
}
