package quiz.entities;
import java.util.List;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="quiz_submission")
public class QuizSubmission {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="User_id")
	private Account account;
	
	@ManyToOne()
	@JoinColumn(name="Quiz_id")
	private Quiz quiz;
	
	@Temporal (TemporalType.TIMESTAMP)
	private Date submission_time;
	
	@OneToMany(mappedBy="submission")
	private List<Response>responses;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Date getSubmission_time() {
		return submission_time;
	}

	public void setSubmission_time(Date submission_time) {
		this.submission_time = submission_time;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public int getId() {
		return id;
	}
	

}
