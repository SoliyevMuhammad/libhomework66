package org.example.repository;

import org.example.db.Database;
import org.example.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Book getProfileID(int id) {
        String sql = "select * from book " +
                "where id = " + id;
        Book dto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Book.class));
       return dto;
    }

        public Book getProfileTitle(String title) {
        String sql = "select * from book " +
                "where title ="+ title;
            Book dto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Book.class));
            return dto;

    }
    private Book getProfileByResultSet(ResultSet set) {
        String sql = "SELECT * FROM book Where set =" + set;
        Book dto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class));
        return dto;
    }

    public void insertBook(String title, String author, String amount) {

        String sql = "insert into book(title,author,amount)" +
                " values ('%s','%s','%s')";
        sql = String.format(sql,title,author,amount);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);

    }

    public List<Book> getBookList() {
        String sql = "select id , title ,author , amount from book ";
        List<Book> bookList = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Book book = new Book();
                book.setId(set.getInt("id"));
                book.setTitle(set.getString("title"));
                book.setAuthor(set.getString("author"));
                book.setAmount(set.getString("amount"));
                bookList.add(book);
            }
            connection.close();
            return bookList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int deleteBook(int id) {
            String sql = "delete from  book " +
                    "where id =" + id;
         return jdbcTemplate.update(sql);
    }
}
