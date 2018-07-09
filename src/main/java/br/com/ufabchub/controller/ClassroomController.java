package br.com.ufabchub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ufabchub.service.ClassroomService;

@Controller
public class ClassroomController {

	@Autowired
	ClassroomService classrs;
	
	@RequestMapping("classroom")
	public String classroom() {
		//Abre pagina para as Turmas
		return "classroom";
	}
	
	@RequestMapping("addclassroom")
	public String addclassroom() {
		//Abre pagina para cadastro de Turmas
		return "addclassroom";
	}
}
