package br.com.ufabchub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Post extends Publish {

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments;

	public Post() {

	}

	public Post(String body, Student student, Classroom classroom) {
		super(body, student, classroom);
	}

}
