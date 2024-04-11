package com.example.necroliner.bootcamphelpcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.necroliner.bootcamphelpcenter.model.Message;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer>{
    List<Message> findByUserName(String userName);
}
