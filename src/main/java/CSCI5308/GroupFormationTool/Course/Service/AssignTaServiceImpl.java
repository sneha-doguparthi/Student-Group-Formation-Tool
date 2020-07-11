package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoFactory;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseAssociationDao;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;
import CSCI5308.GroupFormationTool.Model.Role;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.DAO.IRoleDao;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;

public class AssignTaServiceImpl implements IAssignTaService {

	@Override
	public ArrayList<IUser> getAllUsers() {
		IUserDao userDao = ProfileDaoFactory.instance().userDao();

		return userDao.getAll();
	}

	@Override
	public Boolean assignTa(String userId, Integer courseId) {
		IRoleDao roleDao = ProfileDaoFactory.instance().roleDao();
		ICourseAssociationDao courseAssociationDao = CourseDaoFactory.instance().courseAssociationDao();

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
