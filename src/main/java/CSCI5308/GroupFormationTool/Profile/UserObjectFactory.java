package CSCI5308.GroupFormationTool.Profile;

public class UserObjectFactory extends UserAbstractFactory {

	@Override
	public IUser userObject() {
		return new User();
	}
}
