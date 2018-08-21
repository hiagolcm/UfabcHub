package br.com.ufabchub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.ufabchub.model.ChatMessage;
import br.com.ufabchub.model.Classroom;
import br.com.ufabchub.repository.ChatMessageRepository;
import br.com.ufabchub.repository.ClassroomRepository;
import br.com.ufabchub.view.APIView;

@RestController
@RequestMapping("/chat/{id}")
public class ChatApi {
	@Autowired
	ChatMessageRepository chatMessageRepository;
	@Autowired
	ClassroomRepository classroomRepository;

	@JsonView(APIView.MessageLoaderView.class)
	@GetMapping
	public List<ChatMessage> findAll(@PathVariable("id") Long id) {
		Optional<Classroom> optClassroom = classroomRepository.findById(id);
		if (optClassroom.isPresent()) {
			Classroom classroom = optClassroom.get();
			return chatMessageRepository.findByClassRoom(classroom);
		}
		return null;
	}
}
