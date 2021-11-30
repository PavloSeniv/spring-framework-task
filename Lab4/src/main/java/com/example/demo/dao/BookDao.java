package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface BookDao extends CrudRepository<Book, Integer> {
    Optional<List<Book>> findByAuthor(String author);

    Optional<List<Book>> findByPublish(String publish);

}
