package CSCI5308.GroupFormationTool.QuestionManager;

import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.Service.QuestionManagerService;
import CSCI5308.GroupFormationTool.QuestionManager.Service.QuestionManagerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionManagerController {

    @GetMapping("/editor-page")
    public String getEditorPage(Model model){
        model.addAttribute("questionObject",new Question());
        return "question/editor-page";
    }

    @PostMapping("/editor-page")
    public ModelAndView storeQuestion(@ModelAttribute("questionObject") Question questionObject , Model model){
        QuestionManagerService questionManagerService = new QuestionManagerServiceImpl();
        boolean message;
        message= questionManagerService.storeQuestionService(questionObject);
        if(message){
            model.addAttribute("message","Question created");
        }
        else{
            model.addAttribute("message","Not created");
        }
        ModelAndView mav = new ModelAndView("redirect:editor-page");
        return mav;
    }

}
