package com.example.virtual_book_store.controller;

import com.example.virtual_book_store.entity.Book;
import com.example.virtual_book_store.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController(value = "/books")
public class BookController {

    BookService bookService;
    BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        try{
            return ResponseEntity.ok(bookService.getAllBooksToDisplay());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
