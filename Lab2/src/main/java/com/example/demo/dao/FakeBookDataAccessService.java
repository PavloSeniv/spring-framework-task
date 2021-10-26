package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("bookFakeDao")
public class FakeBookDataAccessService implements BookDao {
    private static List<Book> DB = new ArrayList<>();

    @Override
    public int create(UUID id, Book book) {
        DB.add(new Book(
                id,
                book.getName(),
                book.getAuthor(),
                book.getYear(),
                book.getPublish(),
                book.getPages()));
        return 1;
    }

    @Override
    public List<Book> getAll() {
        return DB;
    }

    @Override
    public Optional<Book> getById(UUID id) {
        return DB.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Book> getByAuthor(String author) {
        return DB.stream()
                .filter(b -> b.getAuthor().contains(author))
                .findFirst();
    }

    @Override
    public Optional<Book> getByPublish(String publish) {
        return DB.stream()
                .filter(b -> b.getPublish().contains(publish))
                .findFirst();
    }

    @Override
    public int deleteById(UUID id) {
        Optional<Book> book = getById(id);
        if (book.isEmpty())
            return 0;
        DB.remove(book.get());
        return 1;
    }

    @Override
    public int deleteAll() {
        DB.clear();
        return 1;
    }

    @Override
    public int updateById(UUID id, Book update) {
        return getById(id)
                .map(b -> {
                    int indexOfPersonToUpdate = DB.indexOf(b);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Book(
                                id,
                                update.getName(),
                                update.getAuthor(),
                                update.getYear(),
                                update.getPublish(),
                                update.getPages()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
