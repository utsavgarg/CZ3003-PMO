package nesims.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import nesims.main.model.ChatMessage;

//Event listeners to listen for socket connect and disconnect events so that we can log
//these events and also broadcast them when a user joins or leaves the chat room 
@Component
public class WebSocketEventListener {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		logger.info("Received a new web socket connection");
	}

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

		String username = (String) headerAccessor.getSessionAttributes().get("username");
		String channelType = (String) headerAccessor.getSessionAttributes().get("channeltype");
		if (username != null) {

			logger.info("User Disconnected : " + username);

			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setType(ChatMessage.MessageType.LEAVE);
			chatMessage.setSender(username);

			if (channelType == "cmopmochat")
				messagingTemplate.convertAndSend("/channel/cmopmochat", chatMessage);
			else
				messagingTemplate.convertAndSend("/channel/private", chatMessage);

		}
	}
}