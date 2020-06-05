package com.asdc.group6.CourseAdmin.Service;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.asdc.group6.CourseAdmin.DAO.RoleDao;
import com.asdc.group6.CourseAdmin.DAO.UserDao;
import com.asdc.group6.Models.CourseAssociation;
import com.asdc.group6.Models.Role;
import com.asdc.group6.Models.User;
import com.asdc.group6.CourseAdmin.DAO.CourseAssociationDAO;

@Component
public class AssignTaServiceImpl implements AssignTaService {

	private UserDao userDao;
	private RoleDao roleDao;
	private CourseAssociationDAO courseAssociationDao;
	
	public AssignTaServiceImpl(UserDao userDao, RoleDao roleDao, CourseAssociationDAO courseAssociationDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.courseAssociationDao = courseAssociationDao;
	}
	
	@Override
	public ArrayList<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public Boolean assignTa(String userId, Integer courseId) {
		
		ArrayList<Role> roles = roleDao.findByName("TA");
		String roleId = roles.get(0).getRoleId();
		
		CourseAssociation association = new CourseAssociation();
		association.setUserId(Integer.valueOf(userId));
		association.setRoleId(Integer.valueOf(roleId));
		association.setCourseId(courseId);
		
		courseAssociationDao.insert(association);
		
		return true;
	}

}
