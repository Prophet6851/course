package com.example.course.controller;

import com.example.course.entity.User;
import com.example.course.service.UserService;
import com.example.course.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 注册接口
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.register(user);
            result.put("code", 200);
            result.put("msg", "注册成功");
        } catch (RuntimeException e) {
            result.put("code", 500);
            result.put("msg", "注册失败：" + e.getMessage());
        }
        return result;
    }


    // 登录接口
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            User loginUser = userService.login(user.getUsername(), user.getPassword());
            String token = JwtUtil.generateToken(loginUser.getUsername());

            result.put("code", 200);
            result.put("msg", "登录成功");
            result.put("token", token);
        } catch (RuntimeException e) {
            result.put("code", 500);
            result.put("msg", "登录失败：" + e.getMessage());
            e.printStackTrace(); // 打印具体错误
        }
        return result;
    }
}



//