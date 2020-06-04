package com.asdc.group6.Profile.Registration.Service;

import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.Registration.DAO.RegistrationDao;
import com.asdc.group6.Profile.Registration.DAO.RegistrationDaoImpl;

public class RegistrationServiceImpl implements RegistrationService {

	public boolean registerUserService(User u) {
		RegistrationDao registrationDao = new RegistrationDaoImpl();
		return registrationDao.registerUser(u);
	}
}
