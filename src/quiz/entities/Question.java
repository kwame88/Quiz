package quiz.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	
	
	private String text;
	
	@ManyToMany(mappedBy="questions")
	private List<Quiz> quizzes;
	
	@OneToMany(mappedBy="question", cascade = CascadeType.PERSIST)
	private List<Answer> answers;
	
	public void addQuiz(Quiz quiz) {
		
		
		if (quizzes ==null) {
			quizzes= new ArrayList<>();
			
		}
		quizzes.add(quiz);
		if (!quiz.getQuestions().contains (this)) {
			quiz.getQuestions().add(this);
		}
		
	}
	
	public String getText() {
		return text;
	}

	public int getId() {
		return id;
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

	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", quizzes=" + quizzes + ", answers=" + answers + "]";
	}
}
