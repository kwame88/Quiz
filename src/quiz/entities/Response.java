package quiz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="submission_answer")
public class Response {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;
	
	@ManyToOne
	@JoinColumn(name="answer_id")
	private Answer answer;
	
	@ManyToOne
	@JoinColumn(name="submission_id")
	private QuizSubmission submission;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public QuizSubmission getSubmission() {
		return submission;
	}

	public void setSubmission(QuizSubmission submission) {
		this.submission = submission;
	}

	public int getId() {
		return id;
	}

}
