package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {
    int create(UUID id, Book book);

    default int create(Book book) {
        UUID id = UUID.randomUUID();
        return create(id, book);
    }

    List<Book> getAll();

    Optional<Book> getById(UUID id);
    Optional<Book> getByAuthor(String author);
    Optional<Book> getByPublish(String publish);

    int deleteById(UUID id);

    int deleteAll();

    int updateById(UUID id, Book book);
}
