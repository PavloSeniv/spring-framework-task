package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/books")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void createBook(@Valid @NonNull @RequestBody Book book) {
        bookService.create(book);
    }

    @GetMapping(path = "/{id}")
    public Book getById(@PathVariable("id") UUID id) {
        return bookService.bookDao.getById(id)
                .orElse(null);
    }

    @GetMapping(path = "/author")
    public Book getByAuthor(@PathParam("author") String author) {
        return bookService.bookDao.getByAuthor(author)
                .orElse(null);
    }

    @GetMapping(path = "/publish")
    public Book getByPublish(@PathParam("publish") String publish) {
        return bookService.bookDao.getByPublish(publish)
                .orElse(null);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        bookService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        bookService.deleteAll();
    }

    @PutMapping(path = "/{id}")
    public void updateById(@PathVariable("id") UUID id, @RequestBody Book book) {
        bookService.updateById(id, book);
    }
}
