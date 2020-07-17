package CSCI5308.GroupFormationTool.Profile;

public class UserFactory {
	public static IUser userObject(UserAbstractFactory userAbstractFactory) {
		return userAbstractFactory.userObject();
	}
}
