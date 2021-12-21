package com.example.example.demo;

import com.example.example.demo.book.entity.Book;
import com.example.example.demo.book.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class Application {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner fillRepository(@Value("${resources.data.books-path}") String path) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            List<Book> books = mapper.readValue(Paths.get("src", "main", "resources", path).toFile(), new TypeReference<List<Book>>() {
            });

            books.forEach(b -> bookService.addBook(b));
        };
    }

}
