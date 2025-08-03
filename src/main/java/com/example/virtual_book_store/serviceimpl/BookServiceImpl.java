package com.example.virtual_book_store.serviceimpl;

import com.example.virtual_book_store.entity.Book;
import com.example.virtual_book_store.repository.BookRepository;
import com.example.virtual_book_store.service.BookService;
import org.neo4j.driver.exceptions.DatabaseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public List<Book> getAllBooksToDisplay() {
        try {
            return bookRepository.findAll();
        }catch (DatabaseException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> addBooks(List<Book> books) {
       try {
           return bookRepository.saveAll(books);
       }catch (DatabaseException e){
           throw new RuntimeException(e);
       }
    }
}
