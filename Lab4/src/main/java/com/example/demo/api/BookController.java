package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

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
        bookService.save(book);
    }

    @GetMapping
    public List<Book> getAllBook() {
        vat nextIter = bookService.findAll().iterator();
        List<Book> bookList = new ArrayList<>();
        while (nextIter.hasNext()) bookList.add(nextIter.next());
        return bookList;
    }

    @GetMapping(path = "/{id}")
    public Book getBookById(@PathVariable int id, @RequestBody Book book {
        return bookService.getBookById(id).get();

    }

    @GetMapping(path = "/author")
    public List<Book> getBookByAuthor(@PathParam("author") String author) {
        return bookService.getBookByAuthor(author).get();
    }

    @GetMapping(path = "/publish")
    public List<Book> getByPublish(@PathParam("publish") String publish) {
        return bookService.getBookByPublish(publish)
                .get();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBookById(@PathVariable("id") int id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "/{id}")
    public void updateBook(@PathVariable int id, @Valid @NonNull @RequestBody Book book) {
        bookService.save(book);
    }

    @DeleteMapping
    public void deleteAll() {
        bookService.deleteAll();
    }

}

//package com.example.lab4.controller;
//
//        import com.example.lab4.service.LibraryCRUD;
//        import com.example.lab4.service.LibraryJPARep;
//        import com.example.lab4.model.Library;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//@RequestMapping("/Library")
//@RestController
//public class Controller {
//    private final LibraryCRUD libraryService;
//
//    @Autowired
//    public Controller(LibraryCRUD libraryService) {
//        this.libraryService = libraryService;
//    }
//
//    @PostMapping("add")
//    public void add(@RequestBody Library lib){
//        System.out.println("\nADD\n");
//        libraryService.save(lib);
//    }
//
//    @PostMapping(path = "{id}")
//    public void modifyById(@PathVariable int id, @RequestBody Library lib){
//        lib.setId(id);
//        libraryService.save(lib);
//    }
//
//    @DeleteMapping
//    public void deleteAll(){libraryService.deleteAll();}
//
//    @DeleteMapping(path = "id/{id}")
//    public void deleteById(@PathVariable("id") int id){libraryService.deleteById(id);}
//
//    @GetMapping
//    public List<Library> getAll(){
//        var iter = libraryService.findAll().iterator();
//        List<Library> list = new ArrayList<>();
//        while(iter.hasNext())list.add(iter.next());
//        return list;
//    }
//
//    @GetMapping(path = "id/{id}")
//    public Library getById(@PathVariable("id") int id){return libraryService.findById(id).get();}
//
//    @GetMapping(path = "auth/{author}")
//    public List<Library> getByAuthor(@PathVariable("author") String author){return libraryService.findByAuthor(author).get();}
//
//    @GetMapping(path = "pub/{publisher}")
//    public List<Library> getByPublisher(@PathVariable("publisher")String publisher){return libraryService.findByPublisher(publisher).get();}
//
//}
