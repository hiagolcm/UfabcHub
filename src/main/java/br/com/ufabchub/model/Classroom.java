package br.com.ufabchub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 250, nullable = false)
	private String name;

	@Column(length = 250, nullable = false)
	private String campus;

	@Column(length = 250, nullable = false)
	private String period;

	@Column(length = 250, nullable = false)
	private String scheduleClass;

	@Column(length = 250, nullable = false)
	private String scheduleLab;

	@Column(length = 250, nullable = false)
	private String professorClass;

	@Column(length = 250, nullable = false)
	private String professorLab;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "classrooms", cascade = CascadeType.ALL)
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getScheduleClass() {
		return scheduleClass;
	}

	public void setScheduleClass(String scheduleClass) {
		this.scheduleClass = scheduleClass;
	}

	public String getScheduleLab() {
		return scheduleLab;
	}

	public void setScheduleLab(String scheduleLab) {
		this.scheduleLab = scheduleLab;
	}

	public String getProfessorClass() {
		return professorClass;
	}

	public void setProfessorClass(String professorClass) {
		this.professorClass = professorClass;
	}

	public String getProfessorLab() {
		return professorLab;
	}

	public void setProfessorLab(String professorLab) {
		this.professorLab = professorLab;
	}

}
