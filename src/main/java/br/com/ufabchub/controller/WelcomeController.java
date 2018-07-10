package br.com.ufabchub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping({"/","/home"})
	public String index(HttpSession session) {
		//Se o usuario estiver logado retorna para o timeliine
		//Se o usuario não estiver logado, retorna para o index.html
		
		String loginStatus = (String) session.getAttribute("loginstatus");
		if (loginStatus == "LOGGED") {
			return "timeline";
		}
		return "index";
	}

}
