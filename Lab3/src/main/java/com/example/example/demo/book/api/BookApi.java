package com.example.example.demo.book.api;

import com.example.example.demo.book.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Book management REST API")
@RequestMapping("/api/v1/book")
public interface BookApi {
    @ApiOperation("Get all books API")
    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Book>> getAllBooks();

    @ApiOperation("Get book by id API")
    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Book> getByBookId(@PathVariable String id);

    @ApiOperation("Create Book API")
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Book> createBook(@RequestBody Book book);

    @ApiOperation("Remove book by id API")
    @GetMapping(value = "remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Book> removeByBookId(@PathVariable String id);

    @ApiOperation("Remove all books API")
    @GetMapping(value = "remove/all")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Book> removeAll();

    @ApiOperation("Update book API")
    @PostMapping(value = "edit")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Book> update(@RequestBody Book book);

    @ApiOperation("Find book by author API")
    @GetMapping("author/{author}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Book>> findByAuthor(@PathVariable String author);

    @ApiOperation("Find book by publisher API")
    @GetMapping("publisher/{publisher}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Book>> findByPublisher(@PathVariable String publisher);

}
