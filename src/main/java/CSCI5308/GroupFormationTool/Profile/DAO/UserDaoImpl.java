package CSCI5308.GroupFormationTool.Profile.DAO;

import CSCI5308.GroupFormationTool.DBConnection.CreateDatabaseConnection;
import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public ArrayList<User> getUserByUserID(ArrayList<Integer> userIds) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs;
        ArrayList<User> users = new ArrayList<>();
        int listSize = userIds.size();

        try {

            connection = CreateDatabaseConnection.instance().createConnection();

            for (int i = 0; i < listSize; i++) {
                String reqQuery = "SELECT * FROM user WHERE user_id = '" + userIds.get(i) + "'";
                statement = connection.prepareStatement(reqQuery);
                rs = statement.executeQuery(reqQuery);
                while (rs.next()) {
                    User user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setBannerId(rs.getString("banner_id"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setUserType(rs.getString("user_type"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Exception occured while getting the user by user id: ", e);
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

        return users;
    }

    @Override
    public ArrayList<User> getAll() {

        Connection connection = null;
        Statement statement = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            connection = CreateDatabaseConnection.instance().createConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM user";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setBannerId(rs.getString("banner_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("user_type"));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("Exception occured while getting all the users: ", e);
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

        return users;
    }

    @Override
    public ArrayList<Integer> getUserID(List<Student> students) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs;
        int listSize = students.size();
        ArrayList<Integer> userIds = new ArrayList<>();
        int userId = 0;

        try {
            connection = CreateDatabaseConnection.instance().createConnection();
            for (int i = 0; i < listSize; i++) {
                String reqQuery = "SELECT user_id FROM user WHERE banner_id=?";
                statement = connection.prepareStatement(reqQuery);
                statement.setString(1, students.get(i).getbId());
                rs = statement.executeQuery();
                if (rs.next())
                    userId = rs.getInt("user_id");
                userIds.add(userId);
            }
        } catch (SQLException e) {
            logger.error("Exception occured while getting the user by id: ", e);
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

        return userIds;
    }

    @Override
    public boolean addUser(List<Student> student) {

        Connection connection = null;
        PreparedStatement statement = null;
        int listSize = student.size();

        try {
            connection = CreateDatabaseConnection.instance().createConnection();
            for (int i = 0; i < listSize; i++) {
                String password = RandomStringUtils.random(10, true, true);
                String reqQuery = "INSERT INTO user (banner_id, first_name, last_name, email, password, user_type) "
                        + "values(?, ?, ?, ?, ?, ?);";
                statement = connection.prepareStatement(reqQuery);
                statement.setString(1, student.get(i).getbId());
                statement.setString(2, student.get(i).getFirstName());
                statement.setString(3, student.get(i).getLastName());
                statement.setString(4, student.get(i).getEmail());
                statement.setString(5, password);
                statement.setString(6, "S");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error("Exception occured while adding the user: ", e);
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
    public ArrayList<String> getPassword(List<Student> students) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs;
        int listSize = students.size();
        ArrayList<String> passwords = new ArrayList<>();
        String password = "";

        try {
            connection = CreateDatabaseConnection.instance().createConnection();
            for (int i = 0; i < listSize; i++) {
                String reqQuery = "SELECT password FROM user WHERE banner_id=?";
                statement = connection.prepareStatement(reqQuery);
                statement.setString(1, students.get(i).getbId());
                rs = statement.executeQuery();
                if (rs.next())
                    password = rs.getString("password");
                passwords.add(password);
            }
        } catch (SQLException e) {
            logger.error("Exception occured while getting the password: ", e);
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

        return passwords;
    }

    @Override
    public ArrayList<User> getByEmail(String email) {

        Connection connection = null;
        Statement statement = null;
        String query = "SELECT * FROM user WHERE email = '" + email + "'";
        ArrayList<User> users = new ArrayList<>();

        try {
            connection = CreateDatabaseConnection.instance().createConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setBannerId(rs.getString("banner_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("user_type"));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("Exception occured while getting the user by email id: ", e);
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

        return users;
    }

    @Override
    public Boolean update(User user) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = CreateDatabaseConnection.instance().createConnection();
            String insertQuery = "UPDATE user SET banner_id = ?, first_name = ?, last_name = ?, email = ?,"
                    + " password = ?, user_type = ? WHERE user_id = ?";
            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, user.getBannerId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getUserType());
            statement.setInt(7, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Exception occured while updating the user details: ", e);
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
    public boolean checkAccess(User user) {
        PreparedStatement statement = null;
        Connection connection = null;
        boolean isUser = false;

        try {
            String query = "SELECT user_type, user_id FROM user WHERE email=? AND password=?;";
            connection = CreateDatabaseConnection.instance().createConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            if (rs.next() == false)
                return isUser;
            else {
                user.setUserId(rs.getInt("user_id"));
                user.setUserType(rs.getString("user_type"));
                isUser = true;
                return isUser;
            }
        } catch (SQLException e) {
            logger.error("Exception occured while checking user access: ", e);
            return isUser;
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
    public boolean registerUser(User user) {
        Connection connection = null;
        boolean isRegistered = false;
        PreparedStatement statement = null;

        try {
            String query = "INSERT INTO user(banner_id,first_name,last_name,email,password,user_type) VALUES(?,?,?,?,?,?);";
            connection = CreateDatabaseConnection.instance().createConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getBannerId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setString(6, "G");

            if (checkAccess(user) == false) {
                int result = statement.executeUpdate();
                isRegistered = result > 0 ? true : false;
            }
        } catch (SQLException e) {
            logger.error("Exception occured while registering the user: ", e);
            isRegistered = false;
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

        return isRegistered;
    }

}
