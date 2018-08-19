package br.com.ufabchub.model;

import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance
public abstract class Publish {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String date;
	@NotNull
	private String body;
	@NotNull
	private int upVotes;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "upVotedPublishes", cascade = CascadeType.ALL)
	private List<Student> students;

	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	public Publish() {
		
	}
	
	public Publish(String body, Student student, Classroom classroom) {
		this.body = body;
		this.student = student;
		this.classroom = classroom;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		this.date = formatter.format(today);
		this.upVotes = 0;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

}
