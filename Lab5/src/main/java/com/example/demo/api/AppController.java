package com.example.demo.api;

import com.example.demo.repository.Repository;
import com.example.demo.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1/coordinates")
public class AppController {
    @Autowired
    private Repository repository;
    @GetMapping
    public @ResponseBody
    Iterable<Model> findAll() {
        return repository.findAll();
    }
}

//@RequestMapping("/api/books")
//@RestController
//public class BookController {
//    private final BookDao BookRepository;
//
//    @Autowired
//    public BookController(BookDao BookRepository) {
//        this.BookRepository = BookRepository;
//    }
//
//    @PostMapping
//    public void add(@RequestBody Book book) {
//        BookRepository.save(book);
//    }
//
//    @PutMapping(path = "{id}")
//    public void modifyById(@PathVariable int id, @RequestBody Book book) {
//        book.setId(id);
//        BookRepository.save(book);
//    }
//
//    @DeleteMapping
//    public void deleteAll() {
//        BookRepository.deleteAll();
//    }
//
//    @DeleteMapping(path = "id/{id}")
//    public void deleteById(@PathVariable("id") int id) {
//        BookRepository.deleteById(id);
//    }
//
//    @GetMapping
//    public List<Book> getAll() {
//        var iter = BookRepository.findAll().iterator();
//        List<Book> list = new ArrayList<>();
//        while (iter.hasNext()) list.add(iter.next());
//        return list;
//    }
//
//    @GetMapping(path = "id/{id}")
//    public Book getById(@PathVariable("id") int id) {
//        return BookRepository.findById(id).get();
//    }
//
//    @GetMapping(path = "author/{author}")
//    public List<Book> getByAuthor(@PathVariable("author") String author) {
//        return BookRepository.findByAuthor(author).get();
//    }
//
//    @GetMapping(path = "publish/{publish}")
//    public List<Book> getByPublish(@PathVariable("publish") String publish) {
//        return BookRepository.findByPublish(publish).get();
//    }
//
//}






