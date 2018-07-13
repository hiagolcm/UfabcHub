package br.com.ufabchub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufabchub.model.Student;
import br.com.ufabchub.service.ClassroomService;
import br.com.ufabchub.service.PublishService;
import br.com.ufabchub.service.StudentService;

@Controller
@RequestMapping("/student")
public class ClassroomController {

	@Autowired
	private PublishService publishsr;
	
	@Autowired
	private ClassroomService classrs;

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/classroom", method = RequestMethod.GET)
	public ModelAndView classroom(HttpSession session) {
		// Abre pagina para as Turmas

		ModelAndView mv = new ModelAndView("/classroom");
		Long studentId = (Long) session.getAttribute("studentid");
		Student student = studentService.findById(studentId);

		// envia a lista de turmas para a view
		mv.addObject("classrooms", student.getClassrooms());
		return mv;
	}

	@RequestMapping(value = "/removeclassroom", method = RequestMethod.GET)
	public ModelAndView removeclassroom(HttpSession session) {
		// Abre pagina para remover as Turmas

		ModelAndView mv = new ModelAndView("/removeclassroom");
		Long studentId = (Long) session.getAttribute("studentid");
		Student student = studentService.findById(studentId);

		// envia a lista de turmas para a view
		mv.addObject("classrooms", student.getClassrooms());
		return mv;
	}

	@RequestMapping(value = "/addclassroom", method = RequestMethod.GET)
	public ModelAndView addclassroom() {
		// Abre pagina para cadastro de Turmas e envia a lista de turmas para a pagina
		ModelAndView mv = new ModelAndView("/addclassroom");
		mv.addObject("classrooms", classrs.listAll());
		return mv;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("classroomId") String classroomId, HttpSession session) {
		// remove uma turma para o aluno

		Long studentId = (Long) session.getAttribute("studentid");
		Student student = studentService.findById(studentId);

		student.getClassrooms().remove(classrs.getClassroomById(Long.parseLong(classroomId)));

		studentService.save(student);

		return "redirect:/student/classroom";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("classroomId") String classroomId, HttpSession session) {
		// registra uma turma para o aluno

		Long studentId = (Long) session.getAttribute("studentid");
		Student student = studentService.findById(studentId);

		student.getClassrooms().add(classrs.getClassroomById(Long.parseLong(classroomId)));

		studentService.save(student);

		return "redirect:/student/classroom";
	}
	
	@RequestMapping(value = "/enter", method = RequestMethod.POST)
	public String enter(@RequestParam("classroomId") String classroomId, HttpSession session) {
		String redirect = "redirect:/student/classroom/" + classroomId; 
		return redirect;
	}
	
	@RequestMapping(value = { "/classroom/{id}"} )
	public ModelAndView lobyClassroom(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("classroomfeed");
		mv.addObject("classrooms", classrs.getClassroomById(id));
		mv.addObject("publishes",publishsr.listByClassroom(classrs.getClassroomById(id)));
		return mv;
	}
	
}
