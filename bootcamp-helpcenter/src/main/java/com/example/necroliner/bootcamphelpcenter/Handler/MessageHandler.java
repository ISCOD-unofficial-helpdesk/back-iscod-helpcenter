package com.example.necroliner.bootcamphelpcenter.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins ="http://127.0.0.1:5173")
public class MessageHandler {
    
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    // reçois sur app/hello
    //envoi sur topic/greetings
    // @MessageMapping("/message")
    // @SendTo("/listen/message")
    // public String handleMessageFromClient(String message) throws Exception {
    //     System.out.println("message: " + message);
    //     return "message: " + message;
    // }
    
    @MessageMapping("/user-message-{userName}")
    public void sendToUser(@Payload String message, @DestinationVariable String userName, @Header("simpSessionId") String sessionId) {
        System.out.println("user: " + message);
        simpMessagingTemplate.convertAndSend("/listen/reply-" + userName, message);
    }

    @MessageMapping("/assist")
    public void sendToAssist(@RequestBody MessageDTO message, @Header("simpSessionId") String sessionId) {

        System.out.println("assist : " + message.getText());
        simpMessagingTemplate.convertAndSend("/listen/assist", message);
    }
    
}