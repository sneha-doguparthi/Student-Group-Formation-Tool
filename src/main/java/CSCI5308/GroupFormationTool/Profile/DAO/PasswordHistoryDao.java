package CSCI5308.GroupFormationTool.Profile.DAO;

import CSCI5308.GroupFormationTool.Model.PasswordHistory;

import java.util.ArrayList;

public interface PasswordHistoryDao {

	Boolean insert(String email, String password);

	ArrayList<PasswordHistory> fetch(String email, Integer limit);
}
