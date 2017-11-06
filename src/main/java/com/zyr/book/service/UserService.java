package com.zyr.book.service;

import com.zyr.book.domain.User;

import java.util.Map;

public interface UserService {
    User insertUser(String name, String book);

    Map<Integer, String> findBookByName(String name) throws Exception;

    void deleteUserById(int id);
}
