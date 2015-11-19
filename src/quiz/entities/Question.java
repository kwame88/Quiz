package quiz.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	public int getId() {
		return id;
	}
	
	private String text;
	
	@ManyToMany(mappedBy="questions")
	private List<Quiz> quizzes;
	
	@OneToMany(mappedBy="question")
	private List<Answer> answers;
	
	
	public String getText() {
		return text;
	}
	

	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	public void setText(String text) {
		this.text = text;
	}


	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
