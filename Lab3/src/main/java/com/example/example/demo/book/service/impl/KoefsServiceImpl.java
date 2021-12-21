package com.example.example.demo.book.service.impl;

import com.example.example.demo.book.entity.Koefs;
import com.example.example.demo.book.entity.KoefsResponse;
import com.example.example.demo.book.repository.KoefsRepository;
import com.example.example.demo.book.service.KoefsService;
import org.springframework.stereotype.Service;

@Service
public class KoefsServiceImpl implements KoefsService {
    private final KoefsRepository koefsRepository;

    public KoefsServiceImpl(KoefsRepository koefsRepository) {
        this.koefsRepository = koefsRepository;
    }

    @Override
    public Koefs addKoefs(Koefs koefs) {
        return koefsRepository.save(koefs);
    }

    @Override
    public KoefsResponse findKoefs(Long id) {
        Koefs koefs = koefsRepository.findById(id).orElse(new Koefs());
        KoefsResponse koefsResponse = new KoefsResponse(koefs);

        double no_x = (double) koefs.getxKoefs().stream().reduce(0, Integer::sum) / koefs.getxKoefs().size();
        double no_y = (double) koefs.getyKoefs().stream().reduce(0, Integer::sum) / koefs.getyKoefs().size();

        double sumXY = 0;

        for (int i = 0; i < koefs.getxKoefs().size(); i++) {
            sumXY += koefs.getxKoefs().get(i) * koefs.getyKoefs().get(i);
        }

        double sumXPow = 0;
        for (int i = 0; i < koefs.getxKoefs().size(); i++) {
            sumXPow += Math.pow(koefs.getxKoefs().get(i), 2);
        }

        double alpha = (sumXY - 10 * no_x * no_y) / (sumXPow - 10 * Math.pow(no_x, 2));
        double beta = no_y - alpha * no_x;

        koefsResponse.setAlpha(alpha);
        koefsResponse.setBeta(beta);
        koefsResponse.setyFormula("y=" + alpha + "*x-" + beta);

        return koefsResponse;
    }
}
