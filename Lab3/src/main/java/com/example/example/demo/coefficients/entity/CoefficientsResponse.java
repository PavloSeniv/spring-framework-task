package com.example.example.demo.coefficients.entity;

public class CoefficientsResponse extends Coefficients {
    private double alpha;
    private double beta;
    private String yFormula;

    public CoefficientsResponse(Coefficients coefficients) {
        super.setId(coefficients.getId());
        super.setCoefficientsX(coefficients.getCoefficientsX());
        super.setCoefficientsY(coefficients.getCoefficientsY());
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

    public String getFormulaY() {
        return yFormula;
    }

    public void setFormulaY(String yFormula) {
        this.yFormula = yFormula;
    }
}
