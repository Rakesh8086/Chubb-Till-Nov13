package com.app.chat;

public class ChatApp {
    public static void main(String[] args) throws InterruptedException {
        ChatRoom room = new ChatRoom("Battlefield");

        Thread user1 = new Thread(new User("Alice", room));
        Thread user2 = new Thread(new User("Bob", room));
        Thread user3 = new Thread(new User("Charlie", room));

        user1.start();
        user2.start();
        user3.start();

        user1.join();
        user2.join();
        user3.join();

        System.out.println("\n=== Chat History ===");
        room.getMessages().forEach(System.out::println);
    }
}

