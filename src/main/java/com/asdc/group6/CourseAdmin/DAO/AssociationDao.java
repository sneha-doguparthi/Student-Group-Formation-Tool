package com.asdc.group6.CourseAdmin.DAO;

import org.springframework.stereotype.Service;
import com.asdc.group6.Models.Association;

@Service
public interface AssociationDao {

	Boolean insert(Association association);
}
