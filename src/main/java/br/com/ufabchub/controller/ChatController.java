package br.com.ufabchub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.ufabchub.model.ChatMessage;
import br.com.ufabchub.model.Classroom;
import br.com.ufabchub.repository.ChatMessageRepository;
import br.com.ufabchub.repository.ClassroomRepository;

@Controller
public class ChatController {
	@Autowired
	ChatMessageRepository chatMessageRepository;
	@Autowired
	ClassroomRepository classroomRepository;
	
	@MessageMapping("/chat.sendMessage/{classRoomId}")
	@SendTo("/room/{classRoomId}")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage, @DestinationVariable Long classRoomId) {
		Optional<Classroom> optClassRoom = classroomRepository.findById(classRoomId);
		if (optClassRoom.isPresent()) {
			Classroom classroom = optClassRoom.get();
			chatMessage.setClassroom(classroom);
		}
		chatMessageRepository.save(chatMessage);
		return chatMessage;
	}

	@MessageMapping("/chat.addUser/{classRoomId}")
	@SendTo("/room/{classRoomId}")
	public ChatMessage addUser(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
}
