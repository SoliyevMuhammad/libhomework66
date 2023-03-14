package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
     public static Connection getConnection() {
         Connection connection = null;
         try {
             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB_Lesson", "postgres", "Oyatillo2003");
             return connection;
         } catch (SQLException e) {
             System.out.println(e.getSQLState());
             e.printStackTrace();
             System.exit(-1);
         }
         return null;
     }
     public static void initTable() {
         String book = "create table if not exists book (" +
                 "id serial primary key," +
                 "title varchar not null," +
                 "author varchar not null," +
                 "publish_year varchar not null," +
                 "amount numeric default 1," +
                 "visible boolean default true)";

         String student = "create table if not exists student (" +
                 "id serial primary key," +
                 "name varchar(15) not null," +
                 "surname varchar(15) not null," +
                 "phone varchar(9) not null," +
                 "birth_date date not null," +
                 "status varchar not null default 'STUDENT'," +
                 "visible boolean default true)";

         String student_book = "create table if not exists students_book (" +
                 "id serial primary key," +
                 "created_date timestamp," +
                 "status varchar default 'TAKEN'," +
                 "returned_date timestamp," +
                 "duration date," +
                 "student_id integer," +
                 "book_id integer," +
                 "foreign key (student_id) references student(id)," +
                 "foreign key (book_id) references book(id))";

         excute(book);
         excute(student);
         excute(student_book);

     }
     private static void excute(String sql) {
         try (Connection con = getConnection()) {
             Statement statement = con.createStatement();
             statement.executeUpdate(sql);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}
