package CSCI5308.GroupFormationTool.Model;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Profile.DAO.IPasswordHistoryDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;

public class PasswordPolicy {

	private final String minimumLength;
	private final String maximumLength;
	private final String minimumUpperCase;
	private final String minimumLowerCase;
	private final String minimumSymbols;
	private final String charsNotAllowed;
	private final String history;

	public PasswordPolicy() {
		this.minimumLength = System.getenv("MINIMUM_LENGTH");
		this.maximumLength = System.getenv("MAXIMUM_LENGTH");
		this.minimumUpperCase = System.getenv("MINIMUM_UPPERCASE");
		this.minimumLowerCase = System.getenv("MINIMUM_LOWERCASE");
		this.minimumSymbols = System.getenv("MINIMUM_SYMBOLS");
		this.charsNotAllowed = System.getenv("CHARS_NOT_ALLOWED");
		this.history = System.getenv("HISTORY");
	}

	public boolean validatePassword(String email, String password) {
		if (!this.minimumLength.equals("FALSE")) {
			if (password.length() < Integer.parseInt(this.minimumLength)) {
				return false;
			}
		}
		if (!this.maximumLength.equals("FALSE")) {
			if (password.length() > Integer.parseInt(this.maximumLength)) {
				return false;
			}
		}

		if (!this.minimumUpperCase.equals("FALSE")) {
			int count = 0;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i))) {
					count++;
				}
			}
			if (count < Integer.parseInt(this.minimumUpperCase)) {
				return false;
			}
		}

		if (!this.minimumLowerCase.equals("FALSE")) {
			int count = 0;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isLowerCase(password.charAt(i))) {
					count++;
				}
			}
			if (count < Integer.parseInt(this.minimumLowerCase)) {
				return false;
			}
		}

		if (!this.minimumSymbols.equals("FALSE")) {
			String symbols = ".+-[]*~_#:?";
			int count = 0;
			for (int i = 0; i < password.length(); i++) {
				if (symbols.contains(Character.toString(password.charAt(i)))) {
					count++;
				}
			}
			if (count < Integer.parseInt(this.minimumSymbols)) {
				return false;
			}
		}

		if (!this.charsNotAllowed.equals("FALSE")) {
			int count = 0;
			for (int i = 0; i < password.length(); i++) {
				if (charsNotAllowed.contains(Character.toString(password.charAt(i)))) {
					count++;
				}
			}
			if (count > 0) {
				return false;
			}
		}

		if (!this.history.equals("FALSE")) {
			IPasswordHistoryDao passwordHistoryDao = ProfileDaoFactory.instance().passwordHistoryDao();
			ArrayList<PasswordHistory> historyList = passwordHistoryDao.fetch(email, Integer.parseInt(this.history));
			boolean matchFound = false;
			for (PasswordHistory history : historyList) {
				if (password.equals(history.getPassword())) {
					matchFound = true;
					break;
				}
			}
			if (matchFound) {
				return false;
			}
		}

		return true;
	}

	public String getMinimumLength() {
		return minimumLength;
	}

	public String getMaximumLength() {
		return maximumLength;
	}

	public String getMinimumUpperCase() {
		return minimumUpperCase;
	}

	public String getMinimumLowerCase() {
		return minimumLowerCase;
	}

	public String getMinimumSymbols() {
		return minimumSymbols;
	}

	public String getCharsNotAllowed() {
		return charsNotAllowed;
	}

	public String getHistory() {
		return history;
	}

}
