package br.com.ufabchub.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufabchub.model.Classroom;
import br.com.ufabchub.model.Student;
import br.com.ufabchub.service.ClassroomService;
import br.com.ufabchub.service.StudentService;

@Controller
public class ClassroomController {

	@Autowired
	private ClassroomService classrs;

	@Autowired
	private StudentService studentService;

	@RequestMapping("classroom")
	public ModelAndView classroom(HttpSession session) {
		// Abre pagina para as Turmas

		ModelAndView mv = new ModelAndView("classroom");

		// envia a lista de turmas para a view
		mv.addObject("classrooms",
				(studentService.findById(((Student) session.getAttribute("student")).getId())).getClassrooms());
		return mv;
	}

	@RequestMapping("removeclassroom")
	public ModelAndView removeclassroom(HttpSession session) {
		// Abre pagina para remover as Turmas

		ModelAndView mv = new ModelAndView("removeclassroom");

		// envia a lista de turmas para a view
		mv.addObject("classrooms",
				(studentService.findById(((Student) session.getAttribute("student")).getId())).getClassrooms());
		return mv;
	}

	@RequestMapping("addclassroom")
	public ModelAndView addclassroom() {
		// Abre pagina para cadastro de Turmas e envia a lista de turmas para a pagina
		ModelAndView mv = new ModelAndView("addclassroom");
		mv.addObject("classrooms", classrs.listAll());
		return mv;
	}

	@RequestMapping("remove")
	public String remove(@RequestParam("classroomId") String classroomId, HttpSession session) {
		// remove uma turma para o aluno

		Long studentId = ((Student) session.getAttribute("student")).getId();
		Student student = studentService.findById(studentId);

		student.getClassrooms().remove(classrs.getClassroomById(Long.parseLong(classroomId)));

		studentService.save(student);

		return "redirect:/classroom";
	}

	@RequestMapping("register")
	public String register(@RequestParam("classroomId") String classroomId, HttpSession session) {
		// registra uma turma para o aluno

		Long studentId = ((Student) session.getAttribute("student")).getId();
		Student student = studentService.findById(studentId);

		student.getClassrooms().add(classrs.getClassroomById(Long.parseLong(classroomId)));

		studentService.save(student);

		return "redirect:/classroom";
	}

}
