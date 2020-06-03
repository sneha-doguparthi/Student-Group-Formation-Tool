package com.asdc.group6.Profile.DAO;

import java.util.ArrayList;

import com.asdc.group6.Models.Otp;

public interface OtpDao {
	
	Boolean insertOtp(Otp otp);
	
	ArrayList<Otp> getOtpByEmail(String email);
}
