package org.example.repository;

import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<Student> getStudentBookInfoList(String studetTakenBook) {
        String sql ="select s.id as sid,sname as sName, b.name as bName"+
                "from students_book sb inner join student as s on s.sid= sb.student.id "+
                " inner join book as b on b.id = sb.book.id ";

        List<Student> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        return  list;
    }

}
