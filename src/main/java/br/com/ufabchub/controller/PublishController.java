package br.com.ufabchub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufabchub.model.Comment;
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
	public String addpost(@RequestParam("classroomId") Long classroomId, @RequestParam("post") String postBody,
			HttpSession session) {
		Publish post = new Post(postBody, studentService.findById((Long) session.getAttribute("studentid")),
				classrs.getClassroomById(classroomId));
		postsr.save(post);

		String redirect = "redirect:/student/classroom/" + String.valueOf(classroomId);
		return redirect;
	}
	
	@RequestMapping(value = "/post/addcomment", method = RequestMethod.POST)
	public String addcomment(@RequestParam("publishId") String publishId, @RequestParam("comment") String commentBody,
			HttpSession session) {
		Publish comment = new Comment(commentBody, studentService.findById((Long) session.getAttribute("studentid")),
				postsr.findById(Long.parseLong(publishId)).getClassroom(), (Post)postsr.findById(Long.parseLong(publishId)));
		postsr.save(comment);

		String redirect = "redirect:/student/classroom/post/" + publishId;
		return redirect;
	}
		
	@RequestMapping(value = "/enter", method = RequestMethod.POST)
	public String enter(@RequestParam("publishId") String postid) {
		String redirect = "redirect:/student/classroom/post/" + postid; 
		return redirect;
	}
	
	@RequestMapping(value = "/post/{id}")
	public ModelAndView lobyPost(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("postdiscuss");
		mv.addObject("publishes",postsr.findById(id));	
		mv.addObject("comments",postsr.listCommentsByPost(id));
		return mv;
	}
}
