package br.com.ufabchub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufabchub.model.Classroom;
import br.com.ufabchub.repository.ClassroomRepository;

@Service
public class ClassroomService {
	@Autowired
	ClassroomRepository classr;
	
	public Iterable<Classroom> listAll(){
		return classr.findAll();
	}
	
	public Classroom getClassroomById(Long Id) {
		return classr.findById(Id).get();
	}

}
