package com.asdc.group6.Profile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.asdc.group6.DBConnection.CreateDatabaseConnection;
import com.asdc.group6.Models.Otp;

@Component
public class OtpDaoImpl implements OtpDao {

	@Override
	public Boolean insertOtp(Otp otp) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = CreateDatabaseConnection.createConnection();

			String insertQuery = "INSERT INTO otp (email,otp,date) values(?,?,?);";
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, otp.getEmail());
			statement.setInt(2, otp.getOtp());
			
			// changing data type of Otp Date from java.util.Date to String
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String otpDate = dateFormat.format(otp.getDate());
			
			// storing value of Date as String
			statement.setString(3, otpDate);
			statement.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Otp> getOtpByEmail(String email) {
		
		Connection connection = null;
		Statement statement = null;
		
		// fetching otp in descending order
		String query = "SELECT * FROM otp WHERE email = '" + email + "' ORDER BY id DESC";
		
		ArrayList<Otp> otpList = new ArrayList<>();
		
		try {
			
			connection = CreateDatabaseConnection.createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
						
			while(rs.next()) {
				Otp otp = new Otp();
				
				otp.setOtp(rs.getInt("otp"));
				otp.setEmail(rs.getString("email"));
				
				// converting date from String to java.util.Date
				Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(rs.getString("date"));
				otp.setDate(date);
				
				otpList.add(otp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (null != statement)
					statement.close();
				
				if (null != connection)
					connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return otpList;
	}
}
