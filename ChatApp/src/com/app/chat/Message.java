package com.app.chat;

import java.time.LocalDateTime;

class Message {
    private final String sender;
    private final String content;
    private final LocalDateTime timestamp;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender() { 
    	return sender; 
    }
    public String getContent() { 
    	return content; 
    }
    public LocalDateTime getTimestamp() { 
    	return timestamp; 
    }

    @Override
    public String toString() {
        return timestamp.toLocalTime() + " " + sender + ": " + content;
    }
}