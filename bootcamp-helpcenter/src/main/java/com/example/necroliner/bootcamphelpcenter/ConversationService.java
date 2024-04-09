package com.example.necroliner.bootcamphelpcenter;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    private final AtomicInteger conversationIdGenerator = new AtomicInteger();
    private final AtomicInteger messageIdGenerator = new AtomicInteger();
    private final ConcurrentHashMap<Integer, Conversation> conversations = new ConcurrentHashMap<>();

    public Conversation createConversation() {
        int id = conversationIdGenerator.incrementAndGet();
        Conversation conversation = new Conversation();
        conversation.setId(id);
        conversations.put(id, conversation);
        return conversation;
    }

    public Message addMessageToConversation(int conversationId, boolean isSupport, String content) {
        Conversation conversation = conversations.get(conversationId);
        if (conversation == null) {
            throw new IllegalArgumentException("Conversation not found");
        }
        Message message = new Message();
        message.setId(messageIdGenerator.incrementAndGet());
        message.setSupport(isSupport);
        message.setContent(content);
        message.setCreatedAt(new Timestamp(1712653219));
        message.setConversationId(conversationId);
        conversation.getMessages().add(message);
        return message;
    }

}
