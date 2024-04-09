package com.example.necroliner.bootcamphelpcenter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.necroliner.bootcamphelpcenter.model.Message;

public interface MessageRepository extends JpaRepository<Message,Integer>{
    
}
