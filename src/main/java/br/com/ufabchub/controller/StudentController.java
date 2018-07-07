package br.com.ufabchub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ufabchub.model.Student;
import br.com.ufabchub.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("signup")
	public String signup() {

		return "signup";
	}

	@RequestMapping("liststudents")
	public String liststudents(Model model) {

		Iterable<Student> students = studentRepository.findAll();

		model.addAttribute("students", students);

		return "liststudents";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("ra") String ra, @RequestParam("name") String nome, @RequestParam("age") int idade,
			@RequestParam("program") String program, Model model) {

		Student student = new Student(ra, nome, idade, program);
		studentRepository.save(student);

		Iterable<Student> students = studentRepository.findAll();

		model.addAttribute("students", students);

		return "liststudents";
	}

}
