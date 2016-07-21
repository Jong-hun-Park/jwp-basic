package next.controller.qna;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class CreateQnaController extends AbstractController{
  
  private static final Logger log = LoggerFactory.getLogger(AddAnswerController.class);

  private QuestionDao questionDao = new QuestionDao();

// Cheating sheet
//
//  @Override
//  public ModelAndView execute(HttpServletRequest req, HttpServletResponse response) throws Exception {
//      Answer answer = new Answer(req.getParameter("writer"), 
//              req.getParameter("contents"), 
//              Long.parseLong(req.getParameter("questionId")));
//      log.debug("answer : {}", answer);
//      
//      Answer savedAnswer = answerDao.insert(answer);
//      return jsonView().addObject("answer", savedAnswer);
//  }
  
  @Override
  public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Question question = new Question(request.getParameter("writer"), 
                request.getParameter("title"),
                request.getParameter("contents"));
    log.debug("question : {}", question);
    
    Question savedQuestion = questionDao.insert(question);
    
    return jspView("redirect:/");
    //return jsonView().addObject("question", savedQuestion);
  }

}
