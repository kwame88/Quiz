package quiz.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import quiz.entities.Quiz;

@Component
@Transactional
public class QuizDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public Quiz getQuiz(int id) {
		
		Quiz q= em.find(Quiz.class, id);
		return q;
	}
	
	
	public void saveQuiz (Quiz quiz){
		if (! em.contains(quiz)) {
			System.out.println("Quiz not managed, merging it now.");
			quiz = em.merge(quiz);
		}
	}
}


