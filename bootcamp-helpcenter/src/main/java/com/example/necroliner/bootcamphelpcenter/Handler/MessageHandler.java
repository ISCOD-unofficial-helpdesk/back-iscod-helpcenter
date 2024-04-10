package com.example.necroliner.bootcamphelpcenter.Handler;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins ="*")
public class MessageHandler {

    // reçois sur app/hello
    //envoi sur topic/greetings
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String handleMessageFromClient(String message) throws Exception {
        System.out.println("message: " + message);
        return "message: " + message;
    }
    
}