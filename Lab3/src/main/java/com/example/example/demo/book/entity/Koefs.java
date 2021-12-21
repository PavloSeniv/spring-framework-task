package com.example.example.demo.book.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Koefs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection
    private List<Integer> xKoefs;
    @ElementCollection
    private List<Integer> yKoefs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getxKoefs() {
        return xKoefs;
    }

    public void setxKoefs(List<Integer> xKoefs) {
        this.xKoefs = xKoefs;
    }

    public List<Integer> getyKoefs() {
        return yKoefs;
    }

    public void setyKoefs(List<Integer> yKoefs) {
        this.yKoefs = yKoefs;
    }
}
