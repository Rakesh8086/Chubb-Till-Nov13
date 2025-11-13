package com.app.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

class ChatRoom {
    private final String name;
    private final ConcurrentLinkedQueue<Message> messages = new ConcurrentLinkedQueue<>();
    private final CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();

    public ChatRoom(String name) {
        this.name = name;
    }

    public void join(User user) {
        users.add(user);
        System.out.println(user.getName() + " joined " + name);
    }

    public void postMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return new ArrayList<>(messages);
    }

    public String getName() {
        return name;
    }
}
