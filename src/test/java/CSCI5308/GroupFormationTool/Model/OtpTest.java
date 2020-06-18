package CSCI5308.GroupFormationTool.Model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class OtpTest {

	@Test
	void testGetId() {
		Otp otp = new Otp();
		otp.setId(12);
		assertTrue(otp.getId().equals(12));
	}

	@Test
	void testSetId() {
		Otp otp = new Otp();
		otp.setId(12);
		assertTrue(otp.getId().equals(12));
	}

	@Test
	void testGetEmail() {
		Otp otp = new Otp();
		otp.setEmail("bob@dal.ca");
		assertTrue(otp.getEmail().equals("bob@dal.ca"));
	}

	@Test
	void testSetEmail() {
		Otp otp = new Otp();
		otp.setEmail("bob@dal.ca");
		assertTrue(otp.getEmail().equals("bob@dal.ca"));
	}

	@Test
	void testGetOtp() {
		Otp otp = new Otp();
		otp.setOtp(1234);
		assertTrue(otp.getOtp().equals(1234));
	}

	@Test
	void testSetOtp() {
		Otp otp = new Otp();
		otp.setOtp(1234);
		assertTrue(otp.getOtp().equals(1234));
	}

	@Test
	void testGetDate() {
		Otp otp = new Otp();

		Date date = new Date();
		otp.setDate(date);
		assertTrue(otp.getDate().equals(date));
	}

	@Test
	void testSetDate() {
		Otp otp = new Otp();

		Date date = new Date();
		otp.setDate(date);
		assertTrue(otp.getDate().equals(date));
	}
}
