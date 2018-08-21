package br.com.ufabchub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufabchub.model.Classroom;
import br.com.ufabchub.model.Comment;
import br.com.ufabchub.model.Publish;
import br.com.ufabchub.model.Student;
import br.com.ufabchub.repository.PublishRepository;

@Service
public class PublishService {
	@Autowired
	PublishRepository publishr;
	
	public List<Publish> listByClassroom(Classroom classroom) {
		return publishr.findAllByClassroom(classroom);
	}
	
	public List<Publish> listByStudent(Student student) {
		return publishr.findAllByStudent(student);
	}
	
	public Iterable<Publish> listAll() {
		return publishr.findAll();
	}
	
	public void save(Publish post) {
		publishr.save(post);
	}
	
	public Publish findById(Long id) {
		return publishr.getById(id);
	}
	
	public List<Publish> listCommentsByPost(Long id) {
		return publishr.getCommentsByPost(id);
	}
	
//	public List<Publish> listMostVoted(Classroom classroom) {
//		return publishr.getMostUpVoted(classroom);
//	}
//	
}
