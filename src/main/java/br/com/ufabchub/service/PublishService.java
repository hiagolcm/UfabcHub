package br.com.ufabchub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufabchub.model.Publish;
import br.com.ufabchub.repository.PublishRepository;

@Service
public class PublishService {
	@Autowired
	PublishRepository publishr;
	
	
	
	
	public Optional<Publish> listByClassroom(Long idClassroom) {
		return publishr.findById(idClassroom);
	}
	
	public Optional<Publish> listPublish(Long idClassroom) {
		return publishr.findById(idClassroom);
	}
	
	public Iterable<Publish> listAll() {
		return publishr.findAll();
	}
	
	public void save(Publish post) {
		publishr.save(post);
	}
	
}
