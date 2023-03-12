package org.example.repository;

import org.example.db.Database;
import org.example.dto.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
@Repository
public class Studentrepository {
    public Student getProfileByPhone(String phone) {
        String sql = "select * from profile " +
                "where phone = ?";
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, phone);
            ResultSet set = statement.executeQuery();
            List<Student> profileList = getProfileByResultSet(set);
            if (profileList.size()==1){
                return profileList.get(0);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }


    private List<Student> getProfileByResultSet(ResultSet set) {
        List<Student> profileList = new LinkedList<>();
        try {
            while (set.next()) {
                Student student = new Student();
                student.setId(set.getInt("id"));
                student.setName(set.getString("name"));
                student.setSurname(set.getString("surname"));
                student.setPhone(set.getString("phone"));
                student.setCreatedDate(set.getTimestamp("created_date").toLocalDateTime());
                student.setVisible(set.getBoolean("visible"));
            }
            return profileList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getProfileByPhoneAndPassword(String name , String phone) {
        Connection connection = null;
        try {
            connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select  * from profile where name = '%s' and phone= '%s' ;", name, phone);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                student.setVisible(resultSet.getBoolean("visible"));
                return student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(-1);
            }

        }
        return null;
    }



}
