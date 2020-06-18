package CSCI5308.GroupFormationTool.Profile.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.PasswordHistory;

public interface PasswordHistoryDao {

	Boolean insert(String email, String password);

	ArrayList<PasswordHistory> fetch(String email, Integer limit);

}
