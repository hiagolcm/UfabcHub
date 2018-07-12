package br.com.ufabchub.model;

import javax.persistence.Entity;

@Entity
public class Comment extends Publish {

	public Comment(String body, Student student, Classroom classroom) {
		super(body, student, classroom);
		// TODO Auto-generated constructor stub
	}

}
