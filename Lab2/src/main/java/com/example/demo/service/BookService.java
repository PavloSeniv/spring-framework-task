package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("mysqlDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int createBook(Book book) {
        return bookDao.createBook(book);
    }

    public List<Book> getAllBook() {
        return this.bookDao.selectAllBook();
    }

    public Optional<Book> getBookById(UUID id) {
        return bookDao.selectBookById(id);
    }

    public Optional<Book> getBookByAuthor(String author) {
        return bookDao.selectBookByAuthor(author);
    }

    public Optional<Book> getBookByPublish(String publish) {
        return bookDao.selectBookByPublish(publish);
    }

    public int deleteBook(UUID id) {
        return bookDao.deleteBookById(id);
    }

    public int updateBook(UUID id, Book newBook) {
        return bookDao.updateBookById(id, newBook);
    }

    public int deleteAll() {
        return bookDao.deleteAll();
    }
}
