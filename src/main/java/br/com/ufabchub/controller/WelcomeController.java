package br.com.ufabchub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		String loginStatus = (String) session.getAttribute("loginstatus");
		if (loginStatus == "LOGGED") {
			return "timeline";
		}
		return "index";
	}

}
