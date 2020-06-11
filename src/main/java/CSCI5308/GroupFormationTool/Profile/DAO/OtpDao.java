package CSCI5308.GroupFormationTool.Profile.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Otp;

public interface OtpDao {

	Boolean insertOtp(Otp otp);

	ArrayList<Otp> getOtpByEmail(String email);
}
