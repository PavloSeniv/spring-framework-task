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
    private Integer id;
    private Integer year;
    private Integer pages;
    private String name;
    private String author;
    private String publish;

    public Book(
            @JsonProperty("id") int id,
            @JsonProperty("year") int year,
            @JsonProperty("pages") int pages,
            @JsonProperty("name") String name,
            @JsonProperty("author") String author,
            @JsonProperty("publish") String publish
    ) {
        this.id = 0;
        this.year = year;
        this.pages = pages;
        this.name = name;
        this.author = author;
        this.publish = publish;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublish() {
        return publish;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
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
