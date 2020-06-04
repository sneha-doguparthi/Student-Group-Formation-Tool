package com.asdc.group6.Profile.Login.Service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.asdc.group6.Models.User;

@Service
public interface LoginService {
	public String checkAccessService(User user, Model model);
}
