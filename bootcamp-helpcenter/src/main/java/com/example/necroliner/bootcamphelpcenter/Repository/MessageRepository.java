package com.example.necroliner.bootcamphelpcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.necroliner.bootcamphelpcenter.model.Message;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer>{
    abstract List<Message> findByUsername(String username);

    @Query("SELECT DISTINCT m.username FROM Message m")
    abstract List<String> findDistinctUsernames();
}
