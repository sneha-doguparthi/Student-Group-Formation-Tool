package com.asdc.group6.Profile.Login.Service;

import org.springframework.stereotype.Component;

import com.asdc.group6.Models.User;
@Component
public interface LoginService {
	public String checkAccessService(User user);
}
