package br.com.ufabchub.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.ufabchub.model.ChatMessage;

@Controller
public class ChatController {
	@MessageMapping("/chat.sendMessage/{classRoomId}")
	@SendTo("/room/{classRoomId}")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

	@MessageMapping("/chat.addUser/{classRoomId}")
	@SendTo("/room/{classRoomId}")
	public ChatMessage addUser(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
}
