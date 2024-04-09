package com.example.necroliner.bootcamphelpcenter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.necroliner.bootcamphelpcenter.model.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation,Integer>{
    
}
