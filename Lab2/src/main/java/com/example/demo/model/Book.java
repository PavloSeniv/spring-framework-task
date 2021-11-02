package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Book {
    private final UUID id;
    private final String name;
    private final String author;
    private final Integer year;
    private final String publish;
    private final Integer pages;

    public Book(@JsonProperty("id") UUID id,
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

    public UUID getId() {
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
}
