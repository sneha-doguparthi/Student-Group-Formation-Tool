package CSCI5308.GroupFormationTool.Profile.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import CSCI5308.GroupFormationTool.Model.Otp;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.DAO.IOtpDao;
import CSCI5308.GroupFormationTool.Profile.DAO.IPasswordHistoryDao;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;

public class OtpServiceImpl implements IOtpService {

	IUserDao userDao;
	IOtpDao otpDao;
	IPasswordHistoryDao passwordHistoryDao;

	@Override
	public String sendOtp(String email) {

		userDao = ProfileDaoFactory.instance().userDao();
		otpDao = ProfileDaoFactory.instance().otpDao();
		IMailService mailService = ProfileServiceFactory.instance().mailService();

		ArrayList<IUser> allUsers = userDao.getByEmail(email);

		if (allUsers.size() == 0) {
			return "user_not_found";
		}

		Otp otp = new Otp();
		otp.setEmail(email);

		Random random = new Random();
		String randomOtp = String.format("%04d", random.nextInt(10000));
		otp.setOtp(Integer.valueOf(randomOtp));
		otp.setDate(new Date());

		String subject = "Your OTP for password reset";
		String text = "We have received password reset request from your end,\n\n Your otp is " + randomOtp
				+ "\n\n Please use this otp within 10 minutes of it's expiry \n\n Thank You!";
		mailService.sendMail(email, subject, text);

		otpDao.insertOtp(otp);

		return "success";
	}

	@Override
	public String verifyOtp(String email, String otp, String password) {

		userDao = ProfileDaoFactory.instance().userDao();
		otpDao = ProfileDaoFactory.instance().otpDao();
		passwordHistoryDao = ProfileDaoFactory.instance().passwordHistoryDao();

		ArrayList<Otp> otpList = otpDao.getOtpByEmail(email);

		Otp latestOtp = otpList.get(0);
		Date latestStamp = latestOtp.getDate();

		Calendar current = Calendar.getInstance();
		current.setTime(latestStamp);
		current.add(Calendar.MINUTE, 10);
		latestStamp = current.getTime();

		if (latestStamp.compareTo(new Date()) < 0) {
			return "otp_expired";
		} else {
			if (Integer.valueOf(otp).equals(latestOtp.getOtp())) {
				ArrayList<IUser> allUsers = userDao.getByEmail(email);
				IUser userToUpdate = allUsers.get(0);
				userToUpdate.setPassword(password);
				userDao.update(userToUpdate);
				passwordHistoryDao.insert(email, password);
				return "password_updated";
			} else {
				return "otp_invalid";
			}
		}
	}

}
