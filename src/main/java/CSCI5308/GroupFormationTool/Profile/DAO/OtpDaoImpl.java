package CSCI5308.GroupFormationTool.Profile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.DBUtil.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.DBUtil.SqlQueryUtil;
import CSCI5308.GroupFormationTool.Model.Otp;

public class OtpDaoImpl implements IOtpDao {

	private Logger logger = LogManager.getLogger(OtpDaoImpl.class);

	@Override
	public Boolean insertOtp(Otp otp) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			String insertQuery = SqlQueryUtil.instance().getQueryByKey("addOtp");
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, otp.getEmail());
			statement.setInt(2, otp.getOtp());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String otpDate = dateFormat.format(otp.getDate());
			statement.setString(3, otpDate);
			statement.executeUpdate();
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

		return true;
	}

	@Override
	public ArrayList<Otp> getOtpByEmail(String email) {

		Connection connection = null;
		PreparedStatement statement = null;
		String query = SqlQueryUtil.instance().getQueryByKey("getOtp");
		ArrayList<Otp> otpList = new ArrayList<>();
		try {
			connection = CreateDatabaseConnection.instance().createConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Otp otp = new Otp();
				otp.setOtp(rs.getInt("otp"));
				otp.setEmail(rs.getString("email"));
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
