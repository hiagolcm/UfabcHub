package br.com.ufabchub.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestParam;
import br.com.ufabchub.model.Publish;
import br.com.ufabchub.model.Student;
import br.com.ufabchub.service.ClassroomService;
import br.com.ufabchub.service.PublishService;
import br.com.ufabchub.service.StudentService;

@Controller
public class WelcomeController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PublishService publishService;
	
	@Autowired
	private ClassroomService classroomService;
	
	@RequestMapping({"/","/home"})
	public ModelAndView index(HttpSession session) {
		//Se o usuario estiver logado retorna para o timeliine
		//Se o usuario não estiver logado, retorna para o index.html
		ModelAndView logged = new ModelAndView("/timeline");
		ModelAndView notLogged = new ModelAndView("/index");
		
		Long userId = (Long) session.getAttribute("studentid");
		if (userId != null) {
			Student aluno = studentService.findById(userId);
			logged.addObject("publishes", publishService.listByStudent(aluno));
			logged.addObject("classrooms", studentService.findById(userId).getClassrooms());
			
			return logged;
		}
		return notLogged;
	}
	
	@RequestMapping(value = {"/welcome/findByClassroom"})
	@ResponseBody
	public List<Publish> listPostByClassroom(@RequestParam("classroomId") Long classroomId) {
		return publishService.listByClassroom(classroomService.getClassroomById(classroomId));
	}

}
