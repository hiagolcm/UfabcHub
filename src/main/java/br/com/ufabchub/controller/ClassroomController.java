package br.com.ufabchub.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufabchub.model.Classroom;
import br.com.ufabchub.model.Student;
import br.com.ufabchub.service.ClassroomService;

@Controller
public class ClassroomController {
	
	@Autowired
	ClassroomService classrs;
	
	@RequestMapping("classroom")
	public ModelAndView classroom(HttpSession session) {
		//Abre pagina para as Turmas
		ModelAndView mv = new ModelAndView("/classroom");
		
		String classroomId = ((Student)session.getAttribute("student")).getClassroomId();
		ArrayList<Classroom> lclassr = new ArrayList<Classroom>();
		String soloId = "";
		
		for (int i = 0; i < classroomId.length(); i++) {
			if (Character.toString(classroomId.charAt(i)).equals(",")) {
				lclassr.add(classrs.getClassroomById(Long.parseLong(soloId)));
				soloId = "";
			}
			else
				soloId += Character.toString(classroomId.charAt(i));
		}
		mv.addObject("classrooms", lclassr);
		return mv;
	}
	
	@RequestMapping("addclassroom")
	public ModelAndView addclassroom() {
		//Abre pagina para cadastro de Turmas e envia a lista de turmas para a pagina
		ModelAndView mv = new ModelAndView("/addclassroom");
		mv.addObject("classrooms", classrs.listAll());
		return mv;
	}
}
