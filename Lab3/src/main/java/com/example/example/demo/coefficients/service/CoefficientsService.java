package com.example.example.demo.coefficients.service;

import com.example.example.demo.coefficients.entity.Coefficients;
import com.example.example.demo.coefficients.entity.CoefficientsResponse;

public interface CoefficientsService {
    Coefficients addCoefficients(Coefficients book);

    CoefficientsResponse findCoefficients(Long id);
}
