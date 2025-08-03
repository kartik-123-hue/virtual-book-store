package com.example.virtual_book_store.controller;

import com.example.virtual_book_store.entity.Book;
import com.example.virtual_book_store.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class BookControllerTest {
    @InjectMocks
    BookController bookController;

    @Mock
    BookService bookService;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void saveBooks() throws Exception {
        Book book=new Book();
        book.setBookName("Harry Potter");
        book.setBookAuthor("JK Rowling");
        book.setBookPublisher("Times");

        MvcResult mvcResult =mockMvc.perform(put("/bookstore/books/addBooks").content(new ObjectMapper().writeValueAsString(List.of(new ObjectMapper().writeValueAsString(book)))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        System.out.println(mvcResult.toString());
    }

}