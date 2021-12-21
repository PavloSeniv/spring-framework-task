//package com.example.example.demo.book.repository.temp.impl;
//
//import com.example.example.demo.book.entity.Book;
//import com.example.example.demo.book.repository.temp.BookRepository;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//import java.util.stream.Collectors;
//
//import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;
//
//@Component
//@Scope(value = SCOPE_SINGLETON)
//public class BookRepositoryImpl implements BookRepository {
//    private final AtomicLong ID = new AtomicLong();
//    private List<Book> books;
//
//    public BookRepositoryImpl() {
//        books = Collections.synchronizedList(new LinkedList<>());
//    }
//
//    public List<Book> getAll() {
//        return books;
//    }
//
////    @Override
////    public Book getById(Long id) {
////        return books.stream().filter(b -> b.getId().equals(id)).findFirst().get();
////    }
////
////    @Override
////    public Book add(Book book) {
////        book.setId(ID.incrementAndGet());
////        books.add(book);
////        return book;
////    }
////
////    @Override
////    public void remove(Long id) {
////        books.removeIf(b -> b.getId().equals(id));
////    }
////
////    @Override
////    public void removeAll() {
////        books.clear();
////    }
////
////    @Override
////    public Book updateBook(Book book) {
////        Book old = books.stream().filter(b -> b.getId().equals(book.getId())).findFirst().get();
////        old.setPublisher(book.getPublisher());
////        old.setPages(book.getPages());
////        old.setAuthor(book.getAuthor());
////        old.setName(book.getName());
////        old.setPublishYear(book.getPublishYear());
////        return old;
////    }
////
////    @Override
////    public List<Book> findByAuthor(String author) {
////        return books.stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
////    }
////
////    @Override
////    public List<Book> findByPublisher(String publisher) {
////        return books.stream().filter(b -> b.getPublisher().equals(publisher)).collect(Collectors.toList());
////    }
//}
