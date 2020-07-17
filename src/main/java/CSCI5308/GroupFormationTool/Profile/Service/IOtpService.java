package CSCI5308.GroupFormationTool.Profile.Service;

public interface IOtpService {

	public String sendOtp(String email);

	public String verifyOtp(String email, String otp, String password);

}
