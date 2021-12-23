package com.example.example.demo.coefficients.service;

import com.example.example.demo.coefficients.entity.Coefficients;
import com.example.example.demo.coefficients.entity.CoefficientsResponse;
import com.example.example.demo.coefficients.repository.CoefficientsRepository;
import org.springframework.stereotype.Service;

@Service
public class CoefficientsServiceImpl implements CoefficientsService {
    private final CoefficientsRepository coefficientsRepository;

    public CoefficientsServiceImpl(CoefficientsRepository coefficientsRepository) {
        this.coefficientsRepository = coefficientsRepository;
    }

    @Override
    public Coefficients addCoefficients(Coefficients book) {
        return coefficientsRepository.save(book);
    }

    @Override
    public CoefficientsResponse findCoefficients(Long id) {
        Coefficients coefficients = coefficientsRepository.findById(id).orElse(new Coefficients());
        CoefficientsResponse coefficientsResponse = new CoefficientsResponse(coefficients);

        double no_x = (double) coefficients.getCoefficientsX().stream().reduce(0, Integer::sum) / coefficients.getCoefficientsX().size();
        double no_y = (double) coefficients.getCoefficientsY().stream().reduce(0, Integer::sum) / coefficients.getCoefficientsY().size();

        double sumXY = 0;

        for (int i = 0; i < coefficients.getCoefficientsX().size(); i++) {
            sumXY += coefficients.getCoefficientsX().get(i) * coefficients.getCoefficientsY().get(i);
        }

        double sumXPow = 0;
        for (int i = 0; i < coefficients.getCoefficientsX().size(); i++) {
            sumXPow += Math.pow(coefficients.getCoefficientsX().get(i), 2);
        }

        double alpha = (sumXY - 10 * no_x * no_y) / (sumXPow - 10 * Math.pow(no_x, 2));
        double beta = no_y - alpha * no_x;

        coefficientsResponse.setAlpha(alpha);
        coefficientsResponse.setBeta(beta);
        coefficientsResponse.setFormulaY("y=" + alpha + "*x-" + beta);

        return coefficientsResponse;
    }
}
