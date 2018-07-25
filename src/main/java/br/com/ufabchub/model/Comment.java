package br.com.ufabchub.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends Publish {

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

	public Comment() {

	}

	public Comment(String body, Student student, Classroom classroom, Post post) {
		super(body, student, classroom);
		this.post = post;
	}

}
