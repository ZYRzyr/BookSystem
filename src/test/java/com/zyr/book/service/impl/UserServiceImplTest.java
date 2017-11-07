package com.zyr.book.service.impl;

import com.zyr.book.domain.User;
import com.zyr.book.enums.ApiErrorType;
import com.zyr.book.exception.UserException;
import com.zyr.book.repository.UserRepository;
import com.zyr.book.service.UserService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void insertUser() throws Exception {
        User user = userService.insertUser("小张", "书1");
        assertEquals("小张", user.getName());
        assertEquals("书1", user.getBook());
    }

    @Test
    public void testFindBookByName() throws Exception {
        List<User> books = userService.findBookByName("小张");
        assertEquals("书1", books.get(0).getBook());
    }

    @Test
    public void testFindBookByNameWithException() throws Exception {
        thrown.expect(UserException.class);
        thrown.expectMessage(ApiErrorType.EMPTY_BOOK.getMessage());
        userService.findBookByName("小王");
    }

    @Test
    public void testDeleteUserById() throws Exception {
        int before = userRepository.findAll().size();
        userService.deleteUserById(1);
        int after = userRepository.findAll().size();
        assertEquals(before - 1, after);
    }
}
