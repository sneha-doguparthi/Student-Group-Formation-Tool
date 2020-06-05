package com.asdc.group6.CourseAdmin.DAO;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.asdc.group6.Models.Role;

@Service
public interface RoleDao {
	
	ArrayList<Role> findByName(String name);
}
