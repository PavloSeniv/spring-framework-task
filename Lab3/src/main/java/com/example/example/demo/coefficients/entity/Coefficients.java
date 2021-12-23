package com.example.example.demo.coefficients.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Coefficients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection
    private List<Integer> CoefficientsX;
    @ElementCollection
    private List<Integer> CoefficientsY;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getCoefficientsX() {
        return CoefficientsX;
    }

    public void setCoefficientsX(List<Integer> coefficientsX) {
        this.CoefficientsX = coefficientsX;
    }

    public List<Integer> getCoefficientsY() {
        return CoefficientsY;
    }

    public void setCoefficientsY(List<Integer> coefficientsY) {
        this.CoefficientsY = coefficientsY;
    }
}
