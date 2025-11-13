package com.smartgateway.service;

import com.smartgateway.model.User;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    // Static container of users
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("AAA",   "AA",   "1111", "2222", 5000.0));
        users.add(new User("BBB",     "BB",     "3333", "4444", 3000.0));
        users.add(new User("CCC", "CC", "5555", "6666", 7000.0));
        users.add(new User("DDD",   "DD",   "7777", "8888", 10000.0));
        users.add(new User("EEE",     "EE",     "9999", "0000", 2500.0));
    }


    public User findByUsername(String username) {
        for(User u : users) {
            if(u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }


    public List<User> getAllUsers() {
        return users;
    }
}
