package br.com.ufabchub.controller;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ufabchub.model.Publish;
import br.com.ufabchub.service.PublishService;

@Controller
public class PublishController {
	
	@Autowired
	PublishService postsr;
	
	@RequestMapping("/addpost")
	public String addPost( ) {
		return "addpost";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("body") String body) {
		
		//Publish post = new Publish(body, );
		
		//postsr.save(body);
		
		return "classroom";
		
	}
	
}
