package br.com.ufabchub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufabchub.model.Classroom;
import br.com.ufabchub.model.Publish;
import br.com.ufabchub.repository.PublishRepository;

@Service
public class PublishService {
	@Autowired
	PublishRepository publishr;
	
	
	
	
	public List<Publish> listByClassroom(Classroom classroom) {
		return publishr.findAllByClassroom(classroom);
	}
	
	public Iterable<Publish> listAll() {
		return publishr.findAll();
	}
	
	public void save(Publish post) {
		publishr.save(post);
	}
	
}
