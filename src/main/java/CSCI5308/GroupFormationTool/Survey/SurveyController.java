package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.Survey.Service.GetQuestionsService;
import CSCI5308.GroupFormationTool.Survey.Service.GetQuestionsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SurveyController {
    List<Question> surveyQuestionslist = new ArrayList<>();
    Question question = new Question();
    GetQuestionsService getQuestionsService = new GetQuestionsServiceImpl();
    @GetMapping("/survey/create-survey")
    public String getAllQuestions(Model model){
        ArrayList<Question> questionslist = getQuestionsService.getQuestionForInstructor();
        model.addAttribute("questions",questionslist);
        model.addAttribute("questionModel",question);
        return ("survey/create-survey");
    }
    @PostMapping("/survey/addQuestions")
    public String addQuestionsToSurvey(Model model, HttpServletRequest httpServletRequest){
        String questionId = httpServletRequest.getParameter("questionSelected");
        ArrayList<Question> questionslist = getQuestionsService.getQuestionForInstructor();
        model.addAttribute("questions",questionslist);
        Question question=getQuestionsService.getOneQuestion(Integer.parseInt(questionId));
        surveyQuestionslist.add(question);
        model.addAttribute("surveyQuestions",surveyQuestionslist);
        return ("survey/create-survey");
    }
    @PostMapping("/survey/delete-question")
    public String deleteQuestion(Model model,HttpServletRequest httpServletRequest){
        String questionId = httpServletRequest.getParameter("deleteQuestionId");
        surveyQuestionslist.remove(question);
        return ("survey/create-survey");
    }

}
