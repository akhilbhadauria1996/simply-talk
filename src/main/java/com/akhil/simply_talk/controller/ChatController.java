package com.akhil.simply_talk.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.akhil.simply_talk.dto.ChatMessage;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
	
	private final SimpMessagingTemplate messagingTemplate;
	
	public void sendMessage(ChatMessage message) {
		messagingTemplate.convertAndSend("topic/messages/"+message.getReceiverId(), message);
		
	}
	

}
