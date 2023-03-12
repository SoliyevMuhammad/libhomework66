package org.example.db;

import java.sql.*;

public class Database {

    public static void init(){

        Student();
      //  initAdmin("Muhammad","soliyev","admin123");
        Book();
        StudentBook();
    }

    public static void initAdmin( String name, String surname, String phone){
        String sql = "insert into profile(name,surname,phone) " +
                "values (?,?,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,surname);
            statement.setString(3,phone);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void Student() {
        String sql = "create table if not exists  profile(id serial primary key," +
                "name varchar ," +
                "surname varchar," +
                "phone  varchar unique  ," +
                "created_date timestamp default now()," +
                "visible boolean default 'true' )";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void Book() {
        String sql = "create table if not exists  book(id serial primary key," +
                "title varchar ," +
                "author varchar," +
                "publishYear timestamp default now() ," +
                "amount varchar ," +
                "visible boolean default 'true' )";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void StudentBook() {
        String sql = "create table if not exists  studentbook(id serial primary key," +
                "student_id integer REFERENCES profile(id) ," +
                "book_id integer REFERENCES book(id)," +
                "publishYear timestamp default now() ," +
                "amount varchar ," +
                "visible boolean)";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_library", "postgres", "admin123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }



}
