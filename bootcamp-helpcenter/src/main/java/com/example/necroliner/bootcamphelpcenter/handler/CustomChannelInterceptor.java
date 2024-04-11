package com.example.necroliner.bootcamphelpcenter.handler;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

public class CustomChannelInterceptor implements ChannelInterceptor {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        if (StompHeaderAccessor.SUBSCRIPTION_ID_HEADER.equals(accessor.getSubscriptionId())) {
            String destination = accessor.getDestination();
            String sessionId = accessor.getSessionId();
            System.out.println("Client subscribed to channel: " + destination + " with sessionId: " + sessionId);
            // Autres actions à effectuer lors de l'abonnement
        }
        return message;
    }
}