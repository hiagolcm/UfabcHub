package br.com.ufabchub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 250, nullable = false)
	private String ra;

	@Column(length = 250, nullable = false)
	private String name;

	// mudar isso aqui depois
	private int age;

	@Column(length = 4, nullable = false)
	private int entryYear;

	@Column(length = 250, nullable = false)
	private String program;

	@Column(length = 250, nullable = false)
	private String email;

	@Column(length = 250, nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "student_classroom", joinColumns = @JoinColumn(name = "sutendt_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "classroom_id", referencedColumnName = "id"))
	private List<Classroom> classrooms;

	public Student() {
		
	}
	
	public Student(String ra, String name, int age, int entryYear, String program, String email, String password) {
		super();
		this.ra = ra;
		this.name = name;
		this.age = age;
		this.entryYear = entryYear;
		this.program = program;
		this.email = email;
		this.password = password;
		this.classrooms = null;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(int entryYear) {
		this.entryYear = entryYear;
	}
	
	public String getprogram() {
		return program;
	}

	public void setprogram(String program) {
		this.program = program;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
