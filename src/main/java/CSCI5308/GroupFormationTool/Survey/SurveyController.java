package CSCI5308.GroupFormationTool.Survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoFactory;
import CSCI5308.GroupFormationTool.Course.DAO.ICourseDao;
import CSCI5308.GroupFormationTool.Course.ICourse;
import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Model.StudentResponse;
import CSCI5308.GroupFormationTool.Model.SurveyResponse;
import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Survey.Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;

@Controller
public class SurveyController {

    ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
    IGetQuestionsService getQuestionsService = SurveyServiceFactory.instance().getQuestionsService();
    private String courseId;

    @GetMapping("/survey/create-survey")
    public String getAllQuestions(Model model, HttpServletRequest request) {
        this.courseId = request.getParameter("courseId");
        survey.setCourseId(Integer.parseInt(courseId));
        ArrayList<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
        model.addAttribute("questions", questionslist);
        model.addAttribute("surveyModel", survey);
        return ("survey/create-survey");
    }

    @PostMapping("/survey/addQuestions")
    public String addQuestionsToSurvey(Model model, HttpServletRequest httpServletRequest) {
        String questionId = httpServletRequest.getParameter("questionSelected");
        this.survey = getQuestionsService.getOneQuestion(survey, Integer.parseInt(questionId));
        ArrayList<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
        model.addAttribute("questions", questionslist);
        model.addAttribute("surveyModel", survey);
        return ("survey/create-survey");
    }

    @GetMapping("/survey/delete-question/{questionid}")
    public String deleteQuestion(@PathVariable("questionid") int questionId, Model model) {
        this.survey = getQuestionsService.deleteQuestion(survey, questionId);
        ArrayList<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
        model.addAttribute("questions", questionslist);
        model.addAttribute("surveyModel", survey);
        return ("survey/create-survey");
    }

    @PostMapping("/survey/save-survey")
    public String saveSurvey(@ModelAttribute("surveyModel") Survey surveyData, String selectedQuestionInfo,
                             Model model) {
        ISurvey survey = SurveyFactory.surveyObject(new SurveyObjectFactory());
        ISaveSurveyService saveSurveyService = SurveyServiceFactory.instance().saveSurveyService();
        IGetQuestionsService getQuestionsService = SurveyServiceFactory.instance().getQuestionsService();
        model.addAttribute("surveyModel", survey);
        List<IQuestion> questionslist = getQuestionsService.getQuestionForInstructor();
        model.addAttribute("questions", questionslist);
        List<IQuestion> questionDetails = saveSurveyService.splitQuestionDetails(selectedQuestionInfo);
        survey.setCourseId(Integer.parseInt(courseId));
        survey.setGroupSize(surveyData.getGroupSize());
        saveSurveyService.saveSurveyDetails(survey);
        saveSurveyService.saveSurveyQuestions(questionDetails, Integer.parseInt(courseId));
        return ("survey/create-survey");
    }

    @PostMapping("/survey/publish")
    public String publish() {
        ISaveSurveyService saveSurveyService = SurveyServiceFactory.instance().saveSurveyService();
        saveSurveyService.updateSurveyStatus(Integer.parseInt(courseId));
        return ("survey/publish-survey");
    }

    @GetMapping("/survey/design-group")
    public String designGroup(HttpServletRequest request, Model model) {

        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int groupSize = Integer.parseInt(request.getParameter("groupSize"));

        IDesignGroupService designGroupService = SurveyServiceFactory.instance().designGroupService();
        Map<String, ArrayList<IUser>> groupInformation = designGroupService.designGroup(courseId);

        ArrayList<IUser> groupedUser = groupInformation.get("groupedUser");
        ArrayList<IUser> unGroupedUser = groupInformation.get("unGroupedUser");

        ArrayList<String> groupedList = new ArrayList<>();
        ArrayList<String> unGroupedList = new ArrayList<>();

        for (int i = 0; i < groupedUser.size() / groupSize; i++){
            List<IUser> list = groupedUser.subList(i*groupSize, i*groupSize + groupSize);

            String sameGroup = "";

            for (IUser user : list){
                sameGroup = sameGroup.concat(user.getBannerId() + "--");
            }

            groupedList.add(sameGroup);
        }

        for (IUser user: unGroupedUser){
            unGroupedList.add(user.getBannerId());
        }

        model.addAttribute("groupedUser", groupedList.toArray());
        model.addAttribute("unGroupedUser", unGroupedList.toArray());

        return "survey/design-group";
    }
}
