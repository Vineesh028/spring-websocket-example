package com.websocket.test.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageHandler implements WebSocketHandler{

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("Connection established on session: {}", session.getId());
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info("Server sends: {}", message);
        
        session.sendMessage(new TextMessage("Sending back message : " + message.getPayload()));

	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.info("Connection closed on session: {} with status: {}", session.getId(), exception.getMessage());
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		log.info("Connection closed on session: {} with status: {}", session.getId(), closeStatus.getCode());
		
	}

	@Override
	public boolean supportsPartialMessages() {
		 return false;
	}

}
