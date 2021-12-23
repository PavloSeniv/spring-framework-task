package com.example.example.demo.coefficients.controller;

import com.example.example.demo.coefficients.api.RegressionApi;
import com.example.example.demo.coefficients.entity.Coefficients;
import com.example.example.demo.coefficients.service.CoefficientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegressionController implements RegressionApi {
    private final CoefficientsService coefficientsService;

    public RegressionController(CoefficientsService coefficientsService) {
        this.coefficientsService = coefficientsService;
    }

    @Override
    public ResponseEntity<Coefficients> findCoefficients(Long id) {
        return ResponseEntity.ok(coefficientsService.findCoefficients(id));
    }

    @Override
    public ResponseEntity<Coefficients> addXYCoefficients(Coefficients coefficients) {
        return ResponseEntity.ok(coefficientsService.addCoefficients(coefficients));
    }
}
