package com.example.example.demo.book.service.impl;

import com.example.example.demo.book.entity.Book;
import com.example.example.demo.book.repository.temp.BookRepositoryTemp;
import com.example.example.demo.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BokServiceImpl implements BookService {
    private final BookRepositoryTemp bookRepository;

    public BokServiceImpl(BookRepositoryTemp bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }

    @Override
    public Book getBooksById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.add(book);
    }

    @Override
    public void removeBookById(Long id) {
        bookRepository.remove(id);
    }

    @Override
    public void removeAllBooks() {
        bookRepository.removeAll();
    }

    @Override
    public Book update(Book book) {
        return bookRepository.updateBook(book);
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
