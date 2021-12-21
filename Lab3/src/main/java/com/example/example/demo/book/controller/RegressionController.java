package com.example.example.demo.book.controller;

import com.example.example.demo.book.api.RegressionApi;
import com.example.example.demo.book.entity.Koefs;
import com.example.example.demo.book.service.KoefsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegressionController implements RegressionApi {
    private final KoefsService koefsService;

    public RegressionController(KoefsService koefsService) {
        this.koefsService = koefsService;
    }

    @Override
    public ResponseEntity<Koefs> findKoefs(Long id) {
        return ResponseEntity.ok(koefsService.findKoefs(id));
    }

    @Override
    public ResponseEntity<Koefs> addXYKoefs(Koefs koefs) {
        return ResponseEntity.ok(koefsService.addKoefs(koefs));
    }
}
