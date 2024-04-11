package com.example.necroliner.bootcamphelpcenter.model;

import java.sql.Timestamp;
import java.time.Instant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Timestamp createAt;
    private boolean isSupport;
    private String username;
    
    public Message(){}
    
    public Message(String content, boolean isSupport, String username) {
        this.createAt = Timestamp.from(Instant.now());
        this.content = content;
        this.isSupport = isSupport;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getCreate_at() {
        return createAt;
    }
    public void setCreate_at(Timestamp createAt) {
        this.createAt = createAt;
    }
    public boolean isSupport() {
        return isSupport;
    }
    public void setSupport(boolean isSupport) {
        this.isSupport = isSupport;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
}
