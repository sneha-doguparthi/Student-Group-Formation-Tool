package CSCI5308.GroupFormationTool.QuestionManager.Service;
import CSCI5308.GroupFormationTool.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.QuestionManagerDao;
import CSCI5308.GroupFormationTool.QuestionManager.DAO.QuestionManagerDaoImpl;

public class QuestionManagerServiceImpl implements QuestionManagerService {
    @Override
    public boolean storeQuestionService(Question question) {
        QuestionManagerDao questionManagerDao = new QuestionManagerDaoImpl();
        return questionManagerDao.insertQuestion(question);
    }
}
