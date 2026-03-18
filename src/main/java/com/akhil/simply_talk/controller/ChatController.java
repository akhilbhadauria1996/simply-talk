package com.akhil.simply_talk.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.akhil.simply_talk.dto.ChatMessage;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
	
	private final SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/send")
	public void sendMessage(ChatMessage message) {
		System.out.println("Received: " + message);
		messagingTemplate.convertAndSend("/topic/messages", message);
		
	}
	
	

}
