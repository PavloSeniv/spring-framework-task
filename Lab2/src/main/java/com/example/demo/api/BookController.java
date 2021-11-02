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
        bookService.createBook(book);
    }

    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @GetMapping(path = "/{id}")
    public Book getBookById(@PathVariable("id") UUID id) {
        return bookService.getBookById(id)
                .orElse(null);
    }

    @GetMapping(path = "/author")
    public Book getBookByAuthor(@PathParam("author") String author) {
        return bookService.getBookByAuthor(author)
                .orElse(null);
    }

    @GetMapping(path = "/publish")
    public Book getByPublish(@PathParam("publish") String publish) {
        return bookService.getBookByPublish(publish)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBookById(@PathVariable("id") UUID id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "/{id}")
    public void updateBook(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Book book) {
        bookService.updateBook(id, book);
    }
    @DeleteMapping
    public void deleteAll() {
        bookService.deleteAll();
    }

}
