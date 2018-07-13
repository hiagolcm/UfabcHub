package br.com.ufabchub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ufabchub.model.Post;
import br.com.ufabchub.model.Publish;
import br.com.ufabchub.service.ClassroomService;
import br.com.ufabchub.service.PublishService;
import br.com.ufabchub.service.StudentService;

@Controller
@RequestMapping("/student/classroom")
public class PublishController {

	@Autowired
	PublishService postsr;

	@Autowired
	private ClassroomService classrs;

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/addpost", method = RequestMethod.POST)
	public String addpost(@RequestParam("classroomId") String classroomId, @RequestParam("post") String postBody,
	public String addpost(@RequestParam("classroomId") Long classroomId, @RequestParam("post") String postBody,
			HttpSession session) {
		Publish post = new Post(postBody, studentService.findById((Long) session.getAttribute("studentid")),
				classrs.getClassroomById(classroomId));
		postsr.save(post);

		String redirect = "redirect:/student/classroom/" + String.valueOf(classroomId);
		return redirect;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam("body") String body) {

		// Publish post = new Publish(body, );

		// postsr.save(body);

		return "classroom";

	}

}
