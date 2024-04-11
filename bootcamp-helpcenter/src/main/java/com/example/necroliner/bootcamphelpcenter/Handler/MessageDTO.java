package com.example.necroliner.bootcamphelpcenter.handler;

public class MessageDTO {
    private String username;
    private String text;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageDTO() {}
}
