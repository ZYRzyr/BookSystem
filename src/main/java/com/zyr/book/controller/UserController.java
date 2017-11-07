package com.zyr.book.controller;

import com.zyr.book.domain.User;
import com.zyr.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User add(User user) throws Exception {
        return userService.insertUser(user.getName(), user.getBook());
    }

    @GetMapping("/show")
    public List<User> show(String name) throws Exception {
        return userService.findByName(name);
    }

    @DeleteMapping("/delete")
    public void delete(String id) throws Exception {
        userService.deleteUserById(Integer.parseInt(id));
    }

    @PutMapping("/modify")
    public void modifyName(String originName, String newName) throws Exception {
        userService.modifyName(originName, newName);
    }
}
