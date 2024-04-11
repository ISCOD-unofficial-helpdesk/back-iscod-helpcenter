package com.example.necroliner.bootcamphelpcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = {"http://127.0.0.1:5173", "http://localhost:5173"})
public class BootcampHelpcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampHelpcenterApplication.class, args);
	}

}