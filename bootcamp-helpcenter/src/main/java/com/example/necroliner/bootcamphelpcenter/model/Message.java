package com.example.necroliner.bootcamphelpcenter.model;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY)
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
    
}
