package CSCI5308.GroupFormationTool.Profile.DAO;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Model.Role;

public interface RoleDao {

	ArrayList<Role> findByName(String name);

}
