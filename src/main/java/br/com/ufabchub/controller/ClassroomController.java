package br.com.ufabchub.controller;

import java.util.ArrayList;

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
		
		ModelAndView mv = new ModelAndView("/classroom");
		ArrayList<Classroom> lclassr = new ArrayList<Classroom>();
		
		lclassr = (ArrayList<Classroom>) session.getAttribute("classrooms");
		//verifica se ja tem uma lista de turmas na sessao do usuario
		if (lclassr == null) {
			//se a lista estiver vazia, atualiza a lista com o que tem no banco de dados
			attStudentClassrooms(session);
			lclassr = (ArrayList<Classroom>) session.getAttribute("classrooms");
		}
		
		//envia a lista de turmas para a view
		mv.addObject("classrooms", lclassr);
		return mv;
	}
	
	@RequestMapping("removeclassroom")
	public ModelAndView removeclassroom(HttpSession session) {
		// Abre pagina para remover as Turmas
		
		ModelAndView mv = new ModelAndView("/removeclassroom");
		ArrayList<Classroom> lclassr = new ArrayList<Classroom>();
		
		lclassr = (ArrayList<Classroom>) session.getAttribute("classrooms");
		
		//envia a lista de turmas para a view
		mv.addObject("classrooms", lclassr);
		return mv;
	}


	@RequestMapping("addclassroom")
	public ModelAndView addclassroom() {
		// Abre pagina para cadastro de Turmas e envia a lista de turmas para a pagina
		ModelAndView mv = new ModelAndView("/addclassroom");
		mv.addObject("classrooms", classrs.listAll());
		return mv;
	}
	
	@RequestMapping("remove")
	public String remove(@RequestParam("classroomId") String classroomId, HttpSession session) {
		//remove uma turma para o aluno
		
		Student student = (Student) session.getAttribute("student");
		
		//remove o Id da turma na tabela do aluno, Id's separados por virgula
		//,Id1,Id2,Id3,
		
		String sclassroomId = student.getClassroomId();
		sclassroomId = sclassroomId.replace((","+classroomId+","), ",");
		student.setClassroomId(sclassroomId);
		studentService.save(student);
		
		//Atualiza a sessao do usuario com a lista de turmas apos o cadastramento
		attStudentClassrooms(session);
		return "redirect:/classroom";
	}

	@RequestMapping("register")
	public String register(@RequestParam("classroomId") String classroomId, HttpSession session) {
		//registra uma turma para o aluno
		
		Student student = (Student) session.getAttribute("student");
		
		//acrescenta o Id da turma na tabela do aluno, Id's separados por virgula
		//,Id1,Id2,Id3,
		classroomId = student.getClassroomId() + classroomId + ",";
		student.setClassroomId(classroomId);
		studentService.save(student);
		
		//Atualiza a sessao do usuario com a lista de turmas apos o cadastramento
		attStudentClassrooms(session);
		return "redirect:/classroom";
	}
	
	
	public void attStudentClassrooms(HttpSession session) {
		//metodo para atualizar as turmas que o usuario esta cadastrado
		
		ArrayList<Classroom> lclassr = new ArrayList<Classroom>();
		String classroomId = ((Student) session.getAttribute("student")).getClassroomId();

		String soloId = "";

		for (int i = 1; i < classroomId.length(); i++) {
			if (Character.toString(classroomId.charAt(i)).equals(",") && !soloId.equals("")) {
				lclassr.add(classrs.getClassroomById(Long.parseLong(soloId)));
				soloId = "";
			} else
				soloId += Character.toString(classroomId.charAt(i));
		}
		session.setAttribute("classrooms", lclassr);
	}

}
