package com.example.course.mapper;

import com.example.course.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 通过用户名查询用户（登录用）
    User findByUsername(String username);

    // 新用户注册
    int insertUser(User user);
}
