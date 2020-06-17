package CSCI5308.GroupFormationTool.Profile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Otp;

public class OtpDaoImpl implements OtpDao {

	private Logger logger = LogManager.getLogger(OtpDaoImpl.class);

	@Override
	public Boolean insertOtp(Otp otp) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = CreateDatabaseConnection.instance().createConnection();

			String insertQuery = "INSERT INTO otp (email,otp,date) values(?,?,?);";
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, otp.getEmail());
			statement.setInt(2, otp.getOtp());

			// changing data type of Otp Date from java.util.Date to String
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String otpDate = dateFormat.format(otp.getDate());

			// storing value of Date as String
			statement.setString(3, otpDate);
			statement.executeUpdate();
			return true;

		} catch (SQLException e) {
			logger.error("Exception occured while inserting OTP: ", e);
			return false;
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occured while closing connection/statement", e);
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

			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Otp otp = new Otp();

				otp.setOtp(rs.getInt("otp"));
				otp.setEmail(rs.getString("email"));

				// converting date from String to java.util.Date
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("date"));
				otp.setDate(date);

				otpList.add(otp);
			}
		} catch (Exception e) {
			logger.error("Exception occured while fetching otp by email id: ", e);
		} finally {
			try {
				if (null != statement) {
					statement.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Exception occured while closing connection/statement", e);
			}
		}

		return otpList;
	}
}
