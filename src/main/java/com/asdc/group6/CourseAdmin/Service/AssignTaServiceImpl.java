package com.asdc.group6.CourseAdmin.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.asdc.group6.CourseAdmin.DAO.AssociationDao;
import com.asdc.group6.CourseAdmin.DAO.RoleDao;
import com.asdc.group6.CourseAdmin.DAO.UserDao;
import com.asdc.group6.Models.Association;
import com.asdc.group6.Models.Role;
import com.asdc.group6.Models.User;

@Component
public class AssignTaServiceImpl implements AssignTaService {

	private UserDao userDao;
	private RoleDao roleDao;
	private AssociationDao associationDao;
	
	public AssignTaServiceImpl(UserDao userDao, RoleDao roleDao, AssociationDao associationDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.associationDao = associationDao;
	}
	
	@Override
	public ArrayList<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public Boolean assignTa(String userId, Integer courseId) {
		
		ArrayList<Role> roles = roleDao.findByName("TA");
		String roleId = roles.get(0).getRoleId();
		
		Association association = new Association();
		association.setUserId(Integer.valueOf(userId));
		association.setRoleId(roleId);
		association.setCourseId(courseId);
		
		associationDao.insert(association);
		
		return true;
	}

}
