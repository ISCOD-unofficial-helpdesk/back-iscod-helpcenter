package com.example.necroliner.bootcamphelpcenter;
///TEMPORAIRE
import java.sql.Timestamp;

public class Message {
    private int id;
    private boolean isSupport;
    private String content;
    private Timestamp createdAt;
    private int conversationId;

    public Message() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isSupport() {
        return isSupport;
    }
    public void setSupport(boolean isSupport) {
        this.isSupport = isSupport;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public int getConversationId() {
        return conversationId;
    }
    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }
}
