package br.com.ufabchub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.ufabchub.model.Student;
import br.com.ufabchub.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("signup")
	public String signup() {

		return "signup";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("ra") String ra, @RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("program") String program, @RequestParam("email") String email,
			@RequestParam("password") String password, Model model) {

		studentService.save(new Student(ra, name, age, program, email, password));

		return "redirect:/login";
	}

	@RequestMapping("login")
	public String index() {
		return "login";
	}

	@RequestMapping("authenticate")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		studentService.authenticate(email, password, session);

		return "redirect:/";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {

		studentService.logout(session);

		return "redirect:/";
	}

}
