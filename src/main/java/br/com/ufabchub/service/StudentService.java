package br.com.ufabchub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufabchub.model.Student;
import br.com.ufabchub.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student) {
		studentRepository.save(student);
	}
	
	public Iterable<Student> listAll() {
		
		Iterable<Student> students = studentRepository.findAll();
		return students;
		

		
	}
}
