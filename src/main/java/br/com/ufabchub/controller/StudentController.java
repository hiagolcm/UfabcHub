package br.com.ufabchub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ufabchub.model.Student;
import br.com.ufabchub.repository.StudentRepository;
import br.com.ufabchub.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("signup")
	public String signup() {

		return "signup";
	}

	@RequestMapping("liststudents")
	public String liststudents(Model model) {

		Iterable<Student> students = studentService.listAll();

		model.addAttribute("students", students);

		return "liststudents";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("ra") String ra, @RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("program") String program, Model model) {
		
		studentService.save(new Student(ra,name,age,program));
		Iterable<Student> students = studentService.listAll();
		model.addAttribute("students",students);
		return "liststudents";
	}

}
