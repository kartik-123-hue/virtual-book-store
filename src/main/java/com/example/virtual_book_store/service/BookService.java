package com.example.virtual_book_store.service;

import com.example.virtual_book_store.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> getAllBooksToDisplay();
}
