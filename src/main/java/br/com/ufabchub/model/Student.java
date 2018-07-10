package br.com.ufabchub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=250, nullable=false)
	private String ra;
	
	@Column(length=250, nullable=false)
	private String name;
	
	//mudar isso aqui depois
	private int age;
	
	@Column(length=250, nullable=false)
	private String program;
	
	@Column(length=250, nullable=false)
	private String email;
	
	@Column(length=250,nullable=false)
	private String password;
	
	@Column(length=250,nullable=true)
	private String classroomId;

	Student(){
		
	}

	public Student(String ra, String name, int age, String program,String email, String password) {
		super();
		this.ra = ra;
		this.name = name;
		this.age = age;
		this.program = program;
		this.email = email;
		this.password = password;
		this.classroomId = ",";
	}

	public String getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
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

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
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
