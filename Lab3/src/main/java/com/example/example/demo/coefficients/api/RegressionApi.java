package com.example.example.demo.coefficients.api;

import com.example.example.demo.coefficients.entity.Coefficients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/regressionCoefficients")
public interface RegressionApi {
    @GetMapping(value = "/coefficients/{id}")
    ResponseEntity<Coefficients> findCoefficients(@PathVariable Long id);

    @PostMapping("/add")
    ResponseEntity<Coefficients> addXYCoefficients(@RequestBody Coefficients coefficients);
}
