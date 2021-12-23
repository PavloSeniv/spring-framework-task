package com.example.example.demo.book.repository.temp;

import com.example.example.demo.book.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {


    //    List<Book> getAll();
//
//    Book getById(Long id);
//
//    Book add(Book book);
//
//    void remove(Long id);
//
//    void removeAll();
//
//    Book updateBook(Book book);

    List<Book> findByAuthor(String author);

    List<Book> findByPublisher(String publisher);
}
