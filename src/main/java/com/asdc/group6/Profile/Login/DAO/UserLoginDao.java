package com.asdc.group6.Profile.Login.DAO;

import com.asdc.group6.Models.User;

public interface UserLoginDao {
	public boolean checkAccess(User user);
}
