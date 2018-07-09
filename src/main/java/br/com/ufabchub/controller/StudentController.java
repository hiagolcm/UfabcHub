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
		//Abre pagina para cadastro
		return "signup";
	}
	
	@RequestMapping("home")
	public String home() {
		//Volta para home
		return "redirect:/";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("ra") String ra, @RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("program") String program, @RequestParam("email") String email,
			@RequestParam("password") String password, Model model) {
		
		//Salva um novo estudante no banco de dados e redireciona para a pagina de login
		
		studentService.save(new Student(ra, name, age, program, email, password));

		return "redirect:/login";
	}

	@RequestMapping("login")
	public String index() {
		//Abre a pagina de login
		return "login";
	}

	@RequestMapping("authenticate")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		//Verifica se o email e senha existe. Se existir o login do usuario é efetuado
		studentService.authenticate(email, password, session);

		return "redirect:/";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		//Faz o logout do usuario
		studentService.logout(session);

		return "redirect:/";
	}

}
