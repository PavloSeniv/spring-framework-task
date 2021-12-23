package com.example.example.demo.book.service.impl;

import com.example.example.demo.book.entity.Book;
import com.example.example.demo.book.repository.temp.BookRepository;
import com.example.example.demo.book.service.BookService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Primary
public class FullBokServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public FullBokServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<Book> bookIterable = bookRepository.findAll();
        List<Book> allBooks = new ArrayList<>();
        bookIterable.forEach(allBooks::add);
        return allBooks;
    }


    @Override
    public Book getBooksById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void removeBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void removeAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> findByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }
}
