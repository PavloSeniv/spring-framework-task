package com.example.example.demo.book.repository.temp;

import com.example.example.demo.book.entity.Book;

import java.util.List;

public interface BookRepositoryTemp {
    List<Book> getAll();

    Book getById(Long id);

    Book add(Book book);

    void remove(Long id);

    void removeAll();

    Book updateBook(Book book);

    List<Book> findByAuthor(String author);

    List<Book> findByPublisher(String publisher);
}
