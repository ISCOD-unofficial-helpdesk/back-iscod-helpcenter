package com.example.necroliner.bootcamphelpcenter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String testEndpoint() {
        // Tu peux mettre du code ici
        return "Test endpoint response";
    }
}
