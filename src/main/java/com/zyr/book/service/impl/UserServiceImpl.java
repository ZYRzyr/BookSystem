package com.zyr.book.service.impl;

import com.zyr.book.domain.Book;
import com.zyr.book.domain.User;
import com.zyr.book.repository.UserRepository;
import com.zyr.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Set<Book> findBookByUserName(String name) {
        return userRepository.findByName(name).getBooks();
    }
}
