package CSCI5308.GroupFormationTool.QuestionManager;

import CSCI5308.GroupFormationTool.Model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionManagerController {

    @GetMapping("/editor-page")
    public String getEditorPage(Model model){
        model.addAttribute("questionObject",new Question());
        return "question/editor-page";
    }
}
