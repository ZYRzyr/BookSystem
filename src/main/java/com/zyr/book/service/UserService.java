package com.zyr.book.service;

import com.zyr.book.domain.User;

import java.util.List;

public interface UserService {
    User insertUser(String name, String book);

    List<User> findBookByName(String name) throws Exception;

    void deleteUserById(int id);
}
