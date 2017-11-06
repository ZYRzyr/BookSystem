package com.zyr.book.service;

import com.zyr.book.domain.Book;
import com.zyr.book.domain.User;

import java.util.Set;

public interface UserService {
    User insertUser(User user);

    Set<Book> findBookByUserName(String name);
}
