package com.zyr.book.controller;

import com.zyr.book.enums.ApiErrorType;
import com.zyr.book.exception.UserException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .param("name", "用户A")
                .param("book", "一本书A"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":0,\"data\":{\"id\":1,\"name\":\"用户A\",\"book\":\"一本书A\"},\"message\":\"添加成功!\"}"))
        ;
    }
}
