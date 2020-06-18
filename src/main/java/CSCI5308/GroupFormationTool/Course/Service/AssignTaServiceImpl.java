package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAO;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;
import CSCI5308.GroupFormationTool.Model.Role;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.RoleDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.SystemConfig;

public class AssignTaServiceImpl implements AssignTaService {

	@Override
	public ArrayList<User> getAllUsers() {
		UserDao userDao = SystemConfig.instance().getUserDao();

		return userDao.getAll();
	}

	@Override
	public Boolean assignTa(String userId, Integer courseId) {
		RoleDao roleDao = SystemConfig.instance().getRoleDao();
		CourseAssociationDAO courseAssociationDao = SystemConfig.instance().getCourseAssociationDAO();

		ArrayList<Role> roles = roleDao.findByName("TA");
		Integer roleId = roles.get(0).getRoleId();

		CourseAssociation association = new CourseAssociation();
		association.setUserId(Integer.parseInt(userId));
		association.setRoleId(roleId);
		association.setCourseId(courseId);
		courseAssociationDao.insert(association);

		return true;
	}
}
