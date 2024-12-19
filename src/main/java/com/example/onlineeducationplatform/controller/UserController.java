package com.example.onlineeducationplatform.controller;

import com.example.onlineeducationplatform.entity.User;
import com.example.onlineeducationplatform.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/home")
    public String showPage() {
        return "home";
    }

    // 处理登录表单提交（POST请求验证登录）
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute User loginUser) {
        System.out.println("Login attempt: " + loginUser.getUsername() + " / " + loginUser.getPassword());

        int result = userService.login(loginUser);

        ModelAndView modelAndView = new ModelAndView();

        if (result == 1) {
            // 登录成功，跳转到首页
            modelAndView.setViewName("home");  // 假设登录成功后跳转到 "home"
        } else if (result == 0) {
            // 密码错误，返回登录页面并显示错误信息
            modelAndView.setViewName("index");
            modelAndView.addObject("error", "Invalid username or password.");
        } else {
            // 用户不存在，返回登录页面并显示错误信息
            modelAndView.setViewName("index");
            modelAndView.addObject("error", "User not found.");
        }

        return modelAndView;
    }
}
