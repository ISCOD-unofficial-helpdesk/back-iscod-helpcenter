package com.example.necroliner.bootcamphelpcenter;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final ConversationService conversationService;

    public ChatController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @MessageMapping("/send")
    public void handleCustomerMessage(@Payload String messageContent, @Header("conversationId") int conversationId) {
        System.out.println(messageContent);
        System.out.println("TEST");
    }

}
