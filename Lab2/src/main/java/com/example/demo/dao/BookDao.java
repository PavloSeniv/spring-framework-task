package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {
    int createBook(UUID id, Book book);
	
    default int createBook(Book book) {
        UUID id = UUID.randomUUID();
        return createBook(id, book);
    }

    List<Book> selectAllBook();

    Optional<Book> selectBookById(UUID id);

    Optional<Book> selectBookByAuthor(String author);

    Optional<Book> selectBookByPublish(String publish);

    int deleteAll();

    int deleteBookById(UUID id);

    int updateBookById(UUID id, Book book);
}
