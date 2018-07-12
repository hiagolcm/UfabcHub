package br.com.ufabchub.model;

import javax.persistence.Entity;

@Entity
public class Post extends Publish{

	public Post(String body, Student student, Classroom classroom) {
		super(body, student, classroom);
		// TODO Auto-generated constructor stub
	}

}
