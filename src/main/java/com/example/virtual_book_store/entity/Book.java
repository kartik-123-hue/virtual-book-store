package com.example.virtual_book_store.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Table
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long Id;

    @Column(name = "BOOK_NAME")
    String bookName;

    @Column(name ="BOOK_AUTHOR")
    String bookAuthor;

    @Column(name = "BOOK_PUBLISHED")
    String bookPublisher;

}
