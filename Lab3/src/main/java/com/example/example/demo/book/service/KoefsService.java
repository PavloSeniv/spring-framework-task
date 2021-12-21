package com.example.example.demo.book.service;

import com.example.example.demo.book.entity.Koefs;
import com.example.example.demo.book.entity.KoefsResponse;

import java.util.List;

public interface KoefsService {
    Koefs addKoefs(Koefs koefs);

    KoefsResponse findKoefs(Long id);
}
