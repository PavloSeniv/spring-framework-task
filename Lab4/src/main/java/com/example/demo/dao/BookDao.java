package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao extends ff<Book,Integer> {
    Optional<List<Book>> selectBookByAuthor(String author);
    Optional<List<Book>> selectBookByPublish(String publish);
}

//package com.example.lab4.service;
//
//        import com.example.lab4.model.Library;
//        import org.springframework.data.repository.CrudRepository;
//
//        import java.util.List;
//        import java.util.Optional;
//
//
//public interface LibraryCRUD extends CrudRepository<Library, Integer> {
//    Optional<List<Library>> findByAuthor(String author);
//    Optional<List<Library>> findByPublisher(String publisher);
//
//}
