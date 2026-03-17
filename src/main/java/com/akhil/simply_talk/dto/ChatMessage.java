package com.akhil.simply_talk.dto;

import lombok.Data;

@Data
public class ChatMessage {
	
	private String senderId;
	private String receiverId;
	private String message;

}
	