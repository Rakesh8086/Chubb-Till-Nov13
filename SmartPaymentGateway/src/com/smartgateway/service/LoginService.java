package com.smartgateway.service;

import com.smartgateway.exception.InvalidCredentialsException;
import com.smartgateway.model.User;


public class LoginService {

    private UserService userService = new UserService();

    public User authenticate(String username, String password) throws InvalidCredentialsException {
        User user = userService.findByUsername(username);
        if(user == null || !user.validatePassword(password)) {
            throw new InvalidCredentialsException("Invalid username or password for user: " + username);
        }
        
        return user;
    }
}
