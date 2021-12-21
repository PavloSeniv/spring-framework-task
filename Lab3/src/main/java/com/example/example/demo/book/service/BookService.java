package com.example.example.demo.book.service;

import com.example.example.demo.book.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBooksById(Long id);

    Book addBook(Book book);

    void removeBookById(Long id);

    void removeAllBooks();

    Book update(Book book);

    List<Book> findByAuthor(String author);

    List<Book> findByPublisher(String publisher);
}
