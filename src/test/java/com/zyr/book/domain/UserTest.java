package com.zyr.book.domain;

import com.zyr.book.repository.BookRepository;
import com.zyr.book.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void test() {
        Book book1 = new Book();
        book1.setName("书1");

        Book book2 = new Book();
        book2.setName("书2");

        Book book3 = new Book();
        book3.setName("书3");

        User user1 = new User();
        user1.setName("小张");
        user1.getBooks().addAll(Arrays.asList(book1, book2));

        User user2 = new User();
        user2.setName("小王");
        user2.getBooks().addAll(Arrays.asList(book2, book3));

        userRepository.save(Arrays.asList(user1, user2));
    }

    @Test
    public void testFindAll() {
        assertThat(userRepository.findAll()).hasSize(2);
        assertThat(bookRepository.findAll()).hasSize(3);
    }
}