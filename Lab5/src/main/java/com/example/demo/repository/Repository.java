package com.example.demo.repository;

import com.example.demo.model.Model;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Model, Long> {
    Model findById(long id);
}