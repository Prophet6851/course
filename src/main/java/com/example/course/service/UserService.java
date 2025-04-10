package com.example.course.service;

import com.example.course.entity.User;

public interface UserService {
    void register(User user);
    User login(String username, String password);
}
