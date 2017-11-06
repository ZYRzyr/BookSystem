package com.zyr.book.service.impl;

import com.zyr.book.domain.Book;
import com.zyr.book.domain.User;
import com.zyr.book.repository.UserRepository;
import com.zyr.book.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @Before
//    public void setup() {
//        Book book1 = new Book();
//        book1.setName("书1");
//
//        Book book2 = new Book();
//        book2.setName("书2");
//
//        Book book3 = new Book();
//        book3.setName("书3");
//
//        User user1 = new User();
//        user1.setName("小张");
//        user1.getBooks().addAll(Arrays.asList(book1, book2));
//
//        User user2 = new User();
//        user2.setName("小王");
//        user2.getBooks().addAll(Arrays.asList(book2, book3));
//
//        userRepository.save(Arrays.asList(user1, user2));
//    }

    @Test
    public void testInsertUser() {
        Book book1 = new Book();
        book1.setName("书1");

        Book book2 = new Book();
        book2.setName("书2");

        User user = new User();
        user.setName("小张");
        user.getBooks().addAll(Arrays.asList(book1, book2));

        User u = userService.insertUser(user);

        assertEquals("小张", u.getName());
    }

    @Test
    public void testFindBookByUserName() {
        Set<Book> books1 = userService.findBookByUserName("小张");
        assertThat(books1).hasSize(2);
    }
}