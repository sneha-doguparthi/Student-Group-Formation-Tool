package CSCI5308.GroupFormationTool.Profile.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Role;

public interface IRoleDao {

	public ArrayList<Role> findByName(String name);

}
