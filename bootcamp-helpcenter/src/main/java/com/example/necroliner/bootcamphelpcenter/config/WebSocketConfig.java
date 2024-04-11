package com.example.necroliner.bootcamphelpcenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.example.necroliner.bootcamphelpcenter.handler.WebSocketListener;

//import com.example.necroliner.bootcamphelpcenter.handler.CustomChannelInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/listen");
    config.setApplicationDestinationPrefixes("/send");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat").setAllowedOrigins("http://localhost:5173", "http://127.0.0.1:5173").setAllowedOriginPatterns("*").withSockJS();
  }

  /*@Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new CustomChannelInterceptor());
    }
    */
    @Bean
    public WebSocketListener webSocketListener() {
        return new WebSocketListener();
    }
}