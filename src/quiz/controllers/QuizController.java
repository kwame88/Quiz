package quiz.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import quiz.data.QuizDao;
import quiz.entities.Answer;
import quiz.entities.Question;
import quiz.entities.Quiz;

@Controller
// @SessionAttributes()
public class QuizController {

	@Autowired
	private QuizDao quizDao;

	@RequestMapping(value = "takeQuiz.do", method = RequestMethod.GET)
	public ModelAndView getQuizName(HttpServletRequest req) { //pass the http request parameter
		req.getSession().setAttribute("quiz", quizDao.getQuiz(1)); //set Quiz to the session level

		return new ModelAndView("takeQuiz.jsp");
	}

	@RequestMapping(value = "checkAnswer.do", method = RequestMethod.POST)
	public ModelAndView validateAnswer(HttpServletRequest req) { // pass the quiz object because it has the parameters

		List<Question> questions = ((Quiz) req.getSession().getAttribute("quiz")).getQuestions(); // Get the quiz atttribute, cast it to Quiz and call the getquestions method
		// store the list of questions in a list 
		Map<String, String[]> userAnswers = req.getParameterMap();  //  Returns a java.util.Map of the parameters of this request. the value is a single array of length 0
		int correctanswers = 0; // create a counter variable

		for (Question question : questions) {
			String questionId = Integer.toString(question.getId()); //loop through the list of questions, get the question id and store it as a string
			List<Answer> answers = question.getAnswers(); // loop through questions again and get list of answers
			if (userAnswers.containsKey(questionId)) { // Using the Map of parameters check to see if user answered question using the question Id
													
				int userAnswerId = Integer.parseInt(userAnswers.get(questionId)[0]); //grab the answer id from the map and save it in a local variable using the array index
				for (Answer answer : answers) {  //loop through the list of answers of each question and check if is equal to the user submission and if isCorrectis == Yes
					if (answer.getId() == userAnswerId && answer.getIsCorrect() == 'Y') {
						correctanswers++;
					}

				}

			}
		}
		Quiz q= (Quiz) req.getSession().getAttribute("quiz");

		double percentCorrect = ( (double) correctanswers / questions.size() )* 100;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("answers.jsp");
		mv.addObject("correctAnswers", correctanswers);
		mv.addObject("percent", percentCorrect);
		mv.addObject("numOfQuestions", questions.size() );
		mv.addObject("quiz", q);
	
		return mv;
	}

	@RequestMapping(value="editQuiz.do", method = RequestMethod.GET)
	public ModelAndView editquiz(HttpServletRequest req) {
		req.getSession().setAttribute("question", quizDao.getQuiz(1));
		
		return new ModelAndView("addquestions.jsp");
	}
	
	@RequestMapping(value="addQuiz.do", method = RequestMethod.POST)
	public ModelAndView addquestion(HttpServletRequest req, AddQuestion question) {
		
		Question newQuestion = new Question();
		newQuestion.setText(question.getQuestion());
		List<Answer>newanswers = new ArrayList<Answer>();
		Answer a1 = new Answer();
		Answer a2 = new Answer();
		Answer a3 = new Answer();
		Answer a4 = new Answer();
		
		a1.setText(question.getAnswer1());
		a2.setText(question.getAnswer2());
		a3.setText(question.getAnswer3());
		a4.setText(question.getAnswer4());
		newanswers.add(a1);
		newanswers.add(a2);
		newanswers.add(a3);
		newanswers.add(a4);
		a1.setIsCorrect(question.getResponse1());
		a2.setIsCorrect(question.getResponse2());
		a3.setIsCorrect(question.getResponse3());
		a4.setIsCorrect(question.getResponse4());
		
		a1.setQuestion(newQuestion);
		a2.setQuestion(newQuestion);
		a3.setQuestion(newQuestion);
		a4.setQuestion(newQuestion);
		
		newQuestion.setAnswers(newanswers);
		Quiz quiz = quizDao.getQuiz(1);
		newQuestion.addQuiz(quiz);
		//quizDao.addQuestion(newQuestion);
		quizDao.saveQuiz(quiz);
		
		return new ModelAndView("addquestions.jsp", "newQuestion", newQuestion);
	}
}
