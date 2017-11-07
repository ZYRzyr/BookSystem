package com.zyr.book.controller;

import com.zyr.book.domain.User;
import com.zyr.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User add(User user) throws Exception {
        return userService.insertUser(user.getName(), user.getBook());
    }

    @GetMapping("/show")
    public Map<Integer, String> show(String name) throws Exception {
        return userService.findBookByName(name);
    }
}
