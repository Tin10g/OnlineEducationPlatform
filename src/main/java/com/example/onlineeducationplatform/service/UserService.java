package com.example.onlineeducationplatform.service;

import com.example.onlineeducationplatform.entity.User;
import com.example.onlineeducationplatform.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public int login(User loginUser){
        // 从数据库获取用户
        User user = userMapper.getUserByName(loginUser.getUsername());

        // 如果用户为空，表示数据库中没有该用户名
        if (ObjectUtils.isEmpty(user)){
            return -1;
        }

        // 如果用户名正确，验证密码
        if (loginUser.getPassword().equals(user.getPassword())){
            return 1;  // 登录成功
        }

        // 密码错误
        return 0;
    }
}
