package com.example.virtual_book_store.controller;

import com.example.virtual_book_store.entity.Book;
import com.example.virtual_book_store.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController(value = "/books")
public class BookController {

    BookService bookService;
    BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PutMapping("/addBooks")
    public ResponseEntity<List<Book>> addBooks(@RequestBody  List<Book> books){
        try {
            return ResponseEntity.ok(bookService.addBooks(books));
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
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
