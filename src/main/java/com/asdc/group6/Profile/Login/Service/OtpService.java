package com.asdc.group6.Profile.Login.Service;

import org.springframework.stereotype.Service;

@Service
public interface OtpService {
	String sendOtp(String email);
	
	String verifyOtp(String email, String otp, String password);
}
