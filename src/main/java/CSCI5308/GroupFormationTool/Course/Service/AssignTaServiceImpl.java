package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAO;
import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAOImpl;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;
import CSCI5308.GroupFormationTool.Model.Role;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.RoleDao;
import CSCI5308.GroupFormationTool.Profile.DAO.RoleDaoImpl;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDaoImpl;

public class AssignTaServiceImpl implements AssignTaService {

	@Override
	public ArrayList<User> getAllUsers() {
		UserDao userDao = new UserDaoImpl();
		return userDao.getAll();
	}

	@Override
	public Boolean assignTa(String userId, Integer courseId) {
		RoleDao roleDao = new RoleDaoImpl();
		CourseAssociationDAO courseAssociationDao = new CourseAssociationDAOImpl();
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
