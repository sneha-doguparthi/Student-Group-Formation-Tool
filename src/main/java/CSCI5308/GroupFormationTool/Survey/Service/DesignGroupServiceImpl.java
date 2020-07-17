package CSCI5308.GroupFormationTool.Survey.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoFactory;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseDao;
import CSCI5308.GroupFormationTool.Model.StudentResponse;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.Survey.ISurvey;

public class DesignGroupServiceImpl implements IDesignGroupService {

	private static Logger logger = LogManager.getLogger(DesignGroupServiceImpl.class);

	public static ArrayList<StudentResponse> sampleGroup = new ArrayList<>();
	public static List<IQuestion> questions;
	public static int groupSize;

	@Override
	public Map<String, ArrayList<String>> designGroup(int courseId) {

		logger.info("Designing group");
		ICourseDao courseDao = CourseDaoFactory.instance().courseDao();
		ICourse course = courseDao.getById(courseId);

		ISurveyService surveyService = SurveyServiceFactory.instance().surveyService();
		ISurvey survey = surveyService.getSurveyForCourse(course);

		groupSize = survey.getGroupSize();
		questions = survey.getQuestionList();

		List<SurveyResponse> responses = surveyService.getResponseForCourse(course);
		ArrayList<Integer> groupedUser = new ArrayList<>();
		ArrayList<Integer> unGroupedUser = new ArrayList<>();
		List<StudentResponse> responseList = new ArrayList<>();

		int questionsSize = questions.size();

		int loopSize = responses.size() / questionsSize;
		for (int i = 0; i < loopSize; i++) {
			StudentResponse response = new StudentResponse();
			response.setUserId(responses.get(questionsSize * i).getUserId());

			for (int j = 0; j < questions.size(); j++) {
				response.getResponseValue().add(responses.get(questionsSize * i + j).getAnswer());
			}
			responseList.add(response);
		}

		for (int i = 0; i < loopSize; i++) {

			if (groupedUser.contains(responseList.get(i).getUserId())) {
				continue;
			}

			sampleGroup.add(responseList.get(i));

			for (int j = i + 1; j < loopSize; j++) {
				if (groupedUser.contains(responseList.get(j).getUserId())) {
					continue;
				}

				if (checkPeers(responseList.get(j))) {
					sampleGroup.add(responseList.get(j));

					if (sampleGroup.size() == groupSize) {
						for (StudentResponse studentResponse : sampleGroup) {
							groupedUser.add(studentResponse.getUserId());
						}

						sampleGroup.clear();
						break;
					}
				}
			}

			if (!groupedUser.contains(responseList.get(i).getUserId())) {
				unGroupedUser.add(responseList.get(i).getUserId());
			}

			sampleGroup.clear();
		}

		IUserDao userDao = ProfileDaoFactory.instance().userDao();

		ArrayList<IUser> groupedUserInfo = userDao.getUserByUserID(groupedUser);
		ArrayList<IUser> unGroupedUserInfo = userDao.getUserByUserID(unGroupedUser);

		ArrayList<String> groupedList = new ArrayList<>();
		ArrayList<String> unGroupedList = new ArrayList<>();

		for (int i = 0; i < groupedUser.size() / groupSize; i++) {
			List<IUser> list = groupedUserInfo.subList(i * groupSize, i * groupSize + groupSize);
			String sameGroup = "";
			for (IUser user : list) {
				sameGroup = sameGroup.concat(
						"( " + user.getBannerId() + " | " + user.getLastName() + " | " + user.getFirstName() + " )  ");
			}
			groupedList.add(sameGroup);
		}
		for (IUser user : unGroupedUserInfo) {
			unGroupedList.add(user.getBannerId() + " | " + user.getLastName() + " | " + user.getFirstName());
		}

		Map<String, ArrayList<String>> groupInformation = new HashMap<>();

		groupInformation.put("groupedUser", groupedList);
		groupInformation.put("unGroupedUser", unGroupedList);
		logger.info("group design algorithm finished");
		return groupInformation;
	}

	public static boolean checkPeers(StudentResponse newUser) {
		logger.info("Checking peer responses");
		for (StudentResponse user : sampleGroup) {

			for (int j = 0; j < user.getResponseValue().size(); j++) {

				switch (questions.get(j).getQuestionType()) {
					case "MCQO":
						if (questions.get(j).getCriteria().equals("SIMILAR")) {
							if (!user.getResponseValue().get(j).equals(newUser.getResponseValue().get(j))) {
								return false;
							}
						} else if (questions.get(j).getCriteria().equals("DISSIMILAR")) {
							if (user.getResponseValue().get(j).equals(newUser.getResponseValue().get(j))) {
								return false;
							}
						}
						break;

					case "FREETEXT":
						if (questions.get(j).getCriteria().equals("SIMILAR")) {
							if (distance(user.getResponseValue().get(j), newUser.getResponseValue().get(j)) < 70) {
								return false;
							}
						} else if (questions.get(j).getCriteria().equals("DISSIMILAR")) {
							if (distance(user.getResponseValue().get(j), newUser.getResponseValue().get(j)) > 70) {
								return false;
							}
						}
						break;

					case "NUM":
						if (questions.get(j).getCriteria().equals("SIMILAR")) {
							if (!user.getResponseValue().get(j).equals(newUser.getResponseValue().get(j))) {
								return false;
							}
						} else if (questions.get(j).getCriteria().equals("DISSIMILAR")) {
							if (user.getResponseValue().get(j).equals(newUser.getResponseValue().get(j))) {
								return false;
							}
						} else if (questions.get(j).getCriteria().startsWith("GT")) {
							if (sampleGroup.size() == groupSize - 1) {
								boolean userWithGT = false;
								int value = Integer.parseInt(questions.get(j).getCriteria().substring(2));

								for (StudentResponse checkUser : sampleGroup) {
									if (Integer.parseInt(checkUser.getResponseValue().get(j)) > value) {
										userWithGT = true;
										break;
									}
								}
								if (!userWithGT) {
									if (Integer.parseInt(newUser.getResponseValue().get(j)) <= value) {
										return false;
									}
								}
							}
						} else if (questions.get(j).getCriteria().startsWith("LT")) {
							if (sampleGroup.size() == groupSize - 1) {
								boolean userWithLT = false;
								int value = Integer.parseInt(questions.get(j).getCriteria().substring(2));

								for (StudentResponse checkUser : sampleGroup) {
									if (Integer.parseInt(checkUser.getResponseValue().get(j)) < value) {
										userWithLT = true;
										break;
									}
								}
								if (!userWithLT) {
									if (Integer.parseInt(newUser.getResponseValue().get(j)) >= value) {
										return false;
									}
								}
							}
						}
						break;

					case "MCQM":
						List<String> userOptions = Arrays.asList(user.getResponseValue().get(j).split("\\|"));
						List<String> newUserOptions = Arrays.asList(newUser.getResponseValue().get(j).split("\\|"));

						int similar = 0;
						int dissimilar = 0;

						for (String option : userOptions) {
							if (newUserOptions.contains(option)) {
								similar++;
							} else {
								dissimilar++;
							}
						}

						for (String option : newUserOptions) {
							if (!userOptions.contains(option)) {
								dissimilar++;
							}
						}

						if (questions.get(j).getCriteria().equals("SIMILAR")) {
							if (dissimilar > similar) {
								return false;
							}
						} else if (questions.get(j).getCriteria().equals("DISSIMILAR")) {
							if (similar > dissimilar) {
								return false;
							}
						}
						break;
				}
			}
		}
		return true;
	}

	public static float distance(String a, String b) {
		logger.info("Calculating the distance");
		a = a.toLowerCase();
		b = b.toLowerCase();

		int[] costs = new int[b.length() + 1];

		for (int j = 0; j < costs.length; j++) {
			costs[j] = j;
		}

		for (int i = 1; i <= a.length(); i++) {
			costs[0] = i;
			int nw = i - 1;

			for (int j = 1; j <= b.length(); j++) {
				int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
						a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
				nw = costs[j];
				costs[j] = cj;
			}
		}

		float maxLength = Math.max(a.length(), b.length());
		float percentage = (maxLength - costs[b.length()]) / maxLength;

		return percentage * 100;
	}
}
