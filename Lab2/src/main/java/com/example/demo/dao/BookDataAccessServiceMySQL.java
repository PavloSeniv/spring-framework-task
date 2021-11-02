package com.example.demo.dao;

import com.example.demo.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("mysqlDao")
public class BookDataAccessServiceMySQL implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDataAccessServiceMySQL(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createBook(UUID id, Book book) {
        System.out.println(book.getName());
        jdbcTemplate.update(
                "INSERT INTO book (id, name,author,year,publish,pages) VALUES (?, ?, ?, ?, ?, ?)",
                id.toString(), book.getName(), book.getAuthor(), book.getYear(), book.getPublish(), book.getPages()
        );
        return 1;
    }

    @Override
    public List<Book> selectAllBook() {
        final String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            Integer year = resultSet.getInt("year");
            String publish = resultSet.getString("publish");
            Integer pages = resultSet.getInt("pages");
            return new Book(id, name, author, year, publish, pages);
        });
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        final String sql = "SELECT * FROM book WHERE id = ?";

        Book book = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id.toString()},
                (resultSet, i) -> {
                    UUID BookId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String author = resultSet.getString("author");
                    Integer year = resultSet.getInt("year");
                    String publish = resultSet.getString("publish");
                    Integer pages = resultSet.getInt("pages");
                    return new Book(BookId, name, author, year, publish, pages);
                });
        return Optional.ofNullable(book);
    }

    @Override
    public Optional<Book> selectBookByAuthor(String author) {
        final String sql = "SELECT * FROM book WHERE author = ?";

        Book book = jdbcTemplate.queryForObject(
                sql,
                new Object[]{author},
                (resultSet, i) -> {
                    UUID id = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String authorBook = resultSet.getString("author");
                    Integer year = resultSet.getInt("year");
                    String publish = resultSet.getString("publish");
                    Integer pages = resultSet.getInt("pages");
                    return new Book(id, name, authorBook, year, publish, pages);
                });
        return Optional.ofNullable(book);
    }

    @Override
    public Optional<Book> selectBookByPublish(String publish) {
        final String sql = "SELECT * FROM book WHERE publish = ?";

        Book book = jdbcTemplate.queryForObject(
                sql,
                new Object[]{publish},
                (resultSet, i) -> {
                    UUID id = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String author = resultSet.getString("author");
                    Integer year = resultSet.getInt("year");
                    String publishBook = resultSet.getString("publish");
                    Integer pages = resultSet.getInt("pages");
                    return new Book(id, name, author, year, publishBook, pages);
                });
        return Optional.ofNullable(book);
    }

    @Override
    public int deleteBookById(UUID id) {
        final String sql = "DELETE FROM book WHERE id = ?";
        Object[] args = new Object[]{id.toString()};
        int row = jdbcTemplate.update(sql, args);
        return row;
    }

    @Override
    public int updateBookById(UUID id, Book book) {
        jdbcTemplate.update(
                "UPDATE book SET id = ?, name = ?,author= ?, year= ?, publish= ?, pages= ?  WHERE id = ?",
                id.toString(), book.getName(), book.getAuthor(), book.getYear(), book.getPublish(), book.getPages(), id.toString()
        );
        return 1;
    }

    @Override
    public int deleteAll() {
        final String sql = "DELETE FROM book";
        int table = jdbcTemplate.update(sql);
        return table;
    }
}
