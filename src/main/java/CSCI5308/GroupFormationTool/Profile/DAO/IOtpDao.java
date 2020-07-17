package CSCI5308.GroupFormationTool.Profile.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Otp;

public interface IOtpDao {

	public Boolean insertOtp(Otp otp);

	public ArrayList<Otp> getOtpByEmail(String email);

}
