package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mysqlDao")
public class BookAccessRepositoryJPA {
    @Autowired
    private BookDao bookDao;
}
