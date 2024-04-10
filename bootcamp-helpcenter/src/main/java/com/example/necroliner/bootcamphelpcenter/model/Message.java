package com.example.necroliner.bootcamphelpcenter.model;

import java.sql.Timestamp;
import java.time.Instant;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_id", nullable = false)
    private Conversation conversation ;

    private String content;
    private Timestamp create_at;
    private boolean isSupport;
    
    public Message(Conversation conversation, String content, boolean isSupport) {
        this.conversation = conversation;
        this.create_at = Timestamp.from(Instant.now());
        this.content = content;
        this.isSupport = isSupport;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Conversation getConversation() {
        return conversation;
    }
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getCreate_at() {
        return create_at;
    }
    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }
    public boolean isSupport() {
        return isSupport;
    }
    public void setSupport(boolean isSupport) {
        this.isSupport = isSupport;
    }
}
