package com.example.necroliner.bootcamphelpcenter.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import com.example.necroliner.bootcamphelpcenter.repository.MessageRepository;

public class WebSocketListener implements ApplicationListener<SessionConnectEvent> {

    @Autowired
    MessageRepository messageRepository;
    
    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String sessionId = accessor.getSessionId();
        System.out.println("New client connected with sessionId: " + sessionId);
    }
}