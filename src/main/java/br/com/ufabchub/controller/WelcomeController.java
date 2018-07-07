package br.com.ufabchub.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class WelcomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
