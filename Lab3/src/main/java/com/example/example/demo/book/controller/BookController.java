package com.example.example.demo.book.controller;

import com.example.example.demo.book.api.BookApi;
import com.example.example.demo.book.entity.Book;
import com.example.example.demo.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController implements BookApi {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Override
    public ResponseEntity<Book> getByBookId(String id) {
        try {
            Long bookId = Long.parseLong(id);
            return ResponseEntity.ok(bookService.getBooksById(bookId));
        } catch (NumberFormatException | NoSuchElementException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<Book> createBook(Book book) {
        if (book.getId() != null || validateBookContent(book)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @Override
    public ResponseEntity<Book> removeByBookId(String id) {
        try {
            Long bookId = Long.parseLong(id);
            bookService.removeBookById(bookId);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Book> update(Book book) {
        try {
            if ((book.getId() == null || book.getId() < 1) || validateBookContent(book)) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(bookService.update(book));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Book> removeAll() {
        bookService.removeAllBooks();
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Book>> findByAuthor(String author) {
        return ResponseEntity.ok(bookService.findByAuthor(author));
    }

    @Override
    public ResponseEntity<List<Book>> findByPublisher(String publisher) {
        return ResponseEntity.ok(bookService.findByPublisher(publisher));
    }

    private boolean validateBookContent(Book book) {
        return (book.getAuthor() == null || book.getAuthor().isEmpty())
                || (book.getName() == null || book.getName().isEmpty())
                || (book.getPages() <= 0)
                || (book.getPublishYear() == null || book.getPublishYear().strip().length() == 0);
    }
}
