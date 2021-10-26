package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    public final BookDao bookDao;
    @Autowired
    public BookService(@Qualifier("bookFakeDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int create(Book book) {
        return bookDao.create(book);
    }

    public List<Book> getAll() {
        return this.bookDao.getAll();
    }

    public int deleteById(UUID id) {
        return bookDao.deleteById(id);
    }

    public int deleteAll() {
        return bookDao.deleteAll();
    }

    public int updateById(UUID id, Book newBook) {
        return bookDao.updateById(id, newBook);
    }
}
