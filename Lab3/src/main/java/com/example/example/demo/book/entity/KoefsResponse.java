package com.example.example.demo.book.entity;

import javax.persistence.*;
import java.util.List;

public class KoefsResponse extends Koefs {
    private double alpha;
    private double beta;
    private String yFormula;

    public KoefsResponse(Koefs koefs) {
        super.setId(koefs.getId());
        super.setxKoefs(koefs.getxKoefs());
        super.setyKoefs(koefs.getyKoefs());
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public String getyFormula() {
        return yFormula;
    }

    public void setyFormula(String yFormula) {
        this.yFormula = yFormula;
    }
}
