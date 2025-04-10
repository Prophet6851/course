package com.example.course.service.impl;

import com.example.course.entity.User;
import com.example.course.mapper.UserMapper;
import com.example.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        // 检查用户名是否已存在
        User existing = userMapper.findByUsername(user.getUsername());
        if (existing != null) {
            throw new RuntimeException("用户名已存在");
        }
        userMapper.insertUser(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("用户名或密码错误");
        }
        return user;
    }
}
