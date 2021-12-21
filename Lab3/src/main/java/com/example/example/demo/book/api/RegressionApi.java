package com.example.example.demo.book.api;

import com.example.example.demo.book.entity.Koefs;
import com.example.example.demo.book.service.KoefsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/regression")
public interface RegressionApi {
    @GetMapping(value = "/koefs/{id}")
    ResponseEntity<Koefs> findKoefs(@PathVariable Long id);

    @PostMapping("new")
    ResponseEntity<Koefs> addXYKoefs(@RequestBody Koefs koefs);


}
