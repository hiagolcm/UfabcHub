package br.com.ufabchub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufabchub.service.PublishService;
import br.com.ufabchub.service.StudentService;

@Controller
public class WelcomeController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PublishService publishService;
	
	@RequestMapping({"/","/home"})
	public ModelAndView index(HttpSession session) {
		//Se o usuario estiver logado retorna para o timeliine
		//Se o usuario não estiver logado, retorna para o index.html
		ModelAndView logged = new ModelAndView("/timeline");
		ModelAndView notLogged = new ModelAndView("/index");
		
		Long userId = (Long) session.getAttribute("studentid");
		if (userId != null) {
			logged.addObject("classrooms", studentService.findById(userId).getClassrooms());
			//logged.addObject("classrooms", publishService.listByStudent(userId));
			return logged;
		}
		return notLogged;
	}

}
