package com.example.necroliner.bootcamphelpcenter;
///TEMPORAIRE
import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private int id;
    private List<Message> messages = new ArrayList<>();
    
    public Conversation() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
