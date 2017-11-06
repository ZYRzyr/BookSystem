package com.zyr.book.controller;

import com.zyr.book.domain.Response;
import com.zyr.book.domain.User;
import com.zyr.book.service.UserService;
import com.zyr.book.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Response add(User user) throws Exception {
        return ResponseUtil
                .success("添加成功!", userService.insertUser(user.getName(), user.getBook()));
    }

    @GetMapping("/show")
    public Response show(String name) throws Exception {
        return ResponseUtil.success(userService.findBookByName(name));
    }
}
