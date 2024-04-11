package com.example.necroliner.bootcamphelpcenter.controller;

import com.example.necroliner.bootcamphelpcenter.model.Message;
import com.example.necroliner.bootcamphelpcenter.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"}, originPatterns =  "*")
public class HistoryController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/history")
    public Map<String, List<Map<String, Object>>> getHistory() {
        List<String> usernames = messageRepository.findDistinctUsernames();
        Map<String, List<Map<String, Object>>> history = new HashMap<>();

        for (String username : usernames) {
            List<Message> messages = messageRepository.findByUsername(username);
            List<Map<String, Object>> messagesData = messages.stream().map(message -> {
                Map<String, Object> messageData = new HashMap<>();
                messageData.put("content", message.getContent());
                messageData.put("isSupport", message.isSupport());
                messageData.put("createAt", message.getCreate_at());
                return messageData;
            }).collect(Collectors.toList());

            history.put(username, messagesData);
        }

        return history;
    }
}
