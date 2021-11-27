package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer id;
    private final String name;
    private final String author;
    private final Integer year;
    private final String publish;
    private final Integer pages;

    public Book(@JsonProperty("id") Integer id,
                @JsonProperty("name") String name,
                @JsonProperty("author") String author,
                @JsonProperty("year") Integer year,
                @JsonProperty("publish") String publish,
                @JsonProperty("pages") Integer pages) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.publish = publish;
        this.pages = pages;
    }

    public Book() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public String getPublish() {
        return publish;
    }

    public Integer getPages() {
        return pages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int Year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }
}

//package com.example.lab4.model;
//
//        import com.fasterxml.jackson.annotation.JsonProperty;
//
//        import javax.persistence.Entity;
//        import javax.persistence.GeneratedValue;
//        import javax.persistence.GenerationType;
//        import javax.persistence.Id;
//
//@Entity
//public class Library {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//    private Integer year;
//    private Integer pages;
//    private String title;
//    private String author;
//    private String publisher;
//
//    public Library(
//            @JsonProperty("id")int id,
//            @JsonProperty("year")int year,
//            @JsonProperty("pages")int pages,
//            @JsonProperty("title")String title,
//            @JsonProperty("author")String author,
//            @JsonProperty("publisher")String publisher
//    ){
//        this.id = id;
//        this.year = year;
//        this.pages = pages;
//        this.title = title;
//        this.author = author;
//        this.publisher = publisher;
//    }
//
//    public Library() {}
//
//    public int getId() {
//        return id;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public int getPages() {
//        return pages;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public String getPublisher() {
//        return publisher;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public void setPages(int pages) {
//        this.pages = pages;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("|id:%d\n|y:%d\n|p:%d\n|t:%s\n|a:%s\n|ps:%s|", id, year, pages, title, author, publisher);
//    }
//}
