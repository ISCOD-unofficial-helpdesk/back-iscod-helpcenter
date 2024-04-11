package com.example.necroliner.bootcamphelpcenter.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.necroliner.bootcamphelpcenter.Repository.MessageRepository;
import com.example.necroliner.bootcamphelpcenter.model.Message;

@Controller
@CrossOrigin(origins ="http://127.0.0.1:5173")
public class MessageHandler {
    
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    MessageRepository messageRepository;

    @MessageMapping("/user-message-{userName}")
    public void sendToUser(@Payload String message, @DestinationVariable String userName) {
        System.out.println("user: " + message);
        Message messageEntity = new Message(message, true, userName);
        messageRepository.save(messageEntity);
        simpMessagingTemplate.convertAndSend("/listen/reply-" + userName, message);
    }

    @MessageMapping("/assist")
    public void sendToAssist(@RequestBody MessageDTO message) {
        System.out.println("assist : " + message.getText());
        Message messageEntity = new Message(message.getText(), false, message.getUsername());
        messageRepository.save(messageEntity);
        simpMessagingTemplate.convertAndSend("/listen/assist", message);
    }
}