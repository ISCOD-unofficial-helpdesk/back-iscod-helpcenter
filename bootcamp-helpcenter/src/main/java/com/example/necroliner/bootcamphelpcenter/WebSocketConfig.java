package com.example.necroliner.bootcamphelpcenter;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint pour démarrer le websocket et la connection entre les pairs
        registry.addEndpoint("/chat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Message Broker sert à router les messages 
        // Du client au helper : message
        // Du helper vers le client: reponse
        registry.enableSimpleBroker("/message", "/reponse");
        // Prefix pour envoyer des messages depuis le client
        registry.setApplicationDestinationPrefixes("/app");
    }
}
