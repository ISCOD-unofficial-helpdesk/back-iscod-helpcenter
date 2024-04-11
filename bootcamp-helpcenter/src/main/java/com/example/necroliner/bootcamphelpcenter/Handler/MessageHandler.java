package com.example.necroliner.bootcamphelpcenter.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.necroliner.bootcamphelpcenter.model.Message;
import com.example.necroliner.bootcamphelpcenter.repository.MessageRepository;

@Controller
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"}, originPatterns =  "*")
public class MessageHandler {
    
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    MessageRepository messageRepository;

    @MessageMapping("/user-message-{userName}")
    public void sendToUser(@Payload String message, @DestinationVariable String userName) {
        //System.out.println("user: " + message);
        if (!message.isEmpty()) {
            Message messageEntity = new Message(message, true, userName);
            messageRepository.save(messageEntity);
        }
        List<Message> conversationHistory = messageRepository.findByUsername(userName);
        //List<String> listeUser = messageRepository.findDistinctUsernames();
        //System.out.println("LISTE USER :" + listeUser);
        simpMessagingTemplate.convertAndSend("/listen/reply-" + userName, conversationHistory);
        simpMessagingTemplate.convertAndSend("/listen/assist", conversationHistory);
        //simpMessagingTemplate.convertAndSend("/listen/assist", listeUser);
    }

    @MessageMapping("/assist")
    public void sendToAssist(@RequestBody MessageDTO message) {
        //System.out.println("assist : " + message.getText());
        if (!message.getText().isEmpty()) {
            Message messageEntity = new Message(message.getText(), false, message.getUsername());
            messageRepository.save(messageEntity);
        }
        List<Message> conversationHistory = messageRepository.findByUsername(message.getUsername());
        //List<String> listeUser = messageRepository.findDistinctUsernames();
        simpMessagingTemplate.convertAndSend("/listen/assist", conversationHistory);
        simpMessagingTemplate.convertAndSend("/listen/reply-" + message.getUsername(), conversationHistory);
        //simpMessagingTemplate.convertAndSend("/listen/assist", listeUser);
    }
}