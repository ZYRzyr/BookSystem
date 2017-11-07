package com.zyr.book.service.impl;

import com.zyr.book.domain.User;
import com.zyr.book.enums.ApiErrorType;
import com.zyr.book.exception.UserException;
import com.zyr.book.repository.UserRepository;
import com.zyr.book.service.UserService;
import com.zyr.book.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insertUser(String name, String book) {
        if (TextUtil.isEmpty(name)) {
            throw new UserException(ApiErrorType.NULL_NAME);
        }

        if (TextUtil.isEmpty(book)) {
            throw new UserException(ApiErrorType.NULL_BOOK);
        }

        return userRepository.save(new User(name, book));
    }

    @Override
    public List<User> findBookByName(String name) throws Exception {
        List<User> users = userRepository.findByName(name);
        if (users.isEmpty()) {
            throw new UserException(ApiErrorType.EMPTY_BOOK);
        }

        return users;
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.delete(new User(id));
    }
}
