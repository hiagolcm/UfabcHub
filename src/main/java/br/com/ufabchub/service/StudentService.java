package br.com.ufabchub.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufabchub.model.Student;
import br.com.ufabchub.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student) {
		//Salva student no banco de dados
		studentRepository.save(student);
	}
	
	public Iterable<Student> listAll() {
		//retorna lista de students cadastros
		Iterable<Student> students = studentRepository.findAll();
		return students;
	}
	
	public void authenticate(String email, String password, HttpSession session) {
		//Faz o login do usuario
		
		//Verifica se existe studente com o mesmo email e senha
		Student student;
		List<Student> students = studentRepository.findByEmailPassword(email, password);
		if(students.size()>0) {
			student = students.get(0);
		}else {
			student = null;
		}
		
		//Atribui valores na session
		if (!student.equals(null)) {
			session.setAttribute("loginstatus","LOGGED");
			session.setAttribute("student", student);
		}else {
			session.setAttribute("loginstatus","NOT_LOGGED");
		}
		
		
	}
	
	public void logout(HttpSession session) {
		//Realiza o logout do usuario
		session.setAttribute("loginstatus","NOT_LOGGED");
		session.setAttribute("student", null);
	}
	
	public Student findById(Long id) {
		return studentRepository.findById(id).get();
	}
}
