package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quiz.entities.Question;
import quiz.entities.Quiz;

public class Test {

	public static void main(String[] args) {
		
		 String persistenceUnitName = "QuizPersistenceUnit";
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	        EntityManager em = emf.createEntityManager();
	        
	        
	        Quiz quiz = em.find(Quiz.class, 1);
	        System.out.println(quiz.getName());
	        
	        Question question = em.find(Question.class, 1);
	        System.out.println(question.getText());
	        
	        List<Question> questions = quiz.getQuestions();
	        
	        for(Question q : questions) {
	            System.out.println(q.getText());
	        }
	}
}
