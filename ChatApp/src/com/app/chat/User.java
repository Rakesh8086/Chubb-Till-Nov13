package com.app.chat;

import java.util.Random;

class User implements Runnable {
    private final String name;
    private final ChatRoom chatRoom;
    private final Random random = new Random();

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() { 
    	return name; 
    }

    private void sendMessage(String content) {
        chatRoom.postMessage(new Message(name, content));
    }

    @Override
    public void run() {
        chatRoom.join(this);
        for (int i = 1; i <= 5; i++) {
            sendMessage("Message " + i + " from " + name);
            try {
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

