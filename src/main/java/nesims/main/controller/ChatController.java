package nesims.main.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import nesims.main.model.ChatMessage;

//Message handling methods in our controller. These methods will be responsible for
//receiving messages from one client and then broadcasting it to others.
@Controller
public class ChatController {

	//CMO-PMO Chat
	@MessageMapping("/chat.sendMessage")
	@SendTo("/channel/cmopmochat")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	//Subscribe user to the CMO-PMO chat
	@MessageMapping("/chat.addUser")
	@SendTo("/channel/cmopmochat")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		headerAccessor.getSessionAttributes().put("channeltype", "cmopmochat");

		return chatMessage;
	}

	//PMO internal Chat
	@MessageMapping("/chat.sendInternalMessage")
	@SendTo("/channel/private")
	public ChatMessage sendInternalMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

	//Subscribe user to the PMO internal chat
	@MessageMapping("/chat.addInternalUser")
	@SendTo("/channel/private")
	public ChatMessage addInternalUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		headerAccessor.getSessionAttributes().put("channeltype", "private");

		return chatMessage;
	}

}