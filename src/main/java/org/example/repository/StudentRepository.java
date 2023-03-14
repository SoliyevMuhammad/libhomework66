package org.example.repository;

import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*public int save(Student student) {
        Connection connection = Database.getConnection();
        try {
            String sql = "insert into student (name, surname, phone, status, birth_date, visible) " + " values ('%s','%s','%s','%s','%s', '%s')";
            sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone(), student.getStatus(), student.getBirthDate());

            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }*/
    public int save(Student student) {
        String sql = "insert into student (name,surname, phone, birth_date, status) values ('%s','%s','%s','%s','%s')";
        sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone(),
                student.getBirthDate(), student.getStatus());
        int n = jdbcTemplate.update(sql);
        return n;
    }
   /* public Student geStudentByPhone(String phone) {
        Connection connection = null;
        try {
            connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select * from student where phone= '%s';", phone);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
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
    }*/
   /*public Student  getStudentByPhone(String phone) {
       String sql = "SELECT * FROM student where phone =" + phone;
       Student student = (Student) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
       return student;
   }*/
  /* public Student getStudentByPhone(String phone) {
       Connection connection = null;
       try {
           connection = Database.getConnection();
           Statement statement = connection.createStatement();
           String sql = String.format("Select  * from student where phone = '%s';", phone);
           ResultSet resultSet = statement.executeQuery(sql);

           while (resultSet.next()) {
               Student profile = new Student();
               profile.setId(resultSet.getInt("id"));
               profile.setName(resultSet.getString("name"));
               profile.setSurname(resultSet.getString("surname"));
               profile.setPhone(resultSet.getString("phone"));
               profile.setStatus(GeneralStatus.valueOf(resultSet.getString("status")));
               return profile;
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
   }*/
   public Student getStudentByPhone(String phone) {
       String sql = String.format("Select  * from student where phone = '%s';", phone);

       List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
       if (list.size() > 0) {
           return list.get(0);
       }
       return null;
   }
    public Student getStudentById(Integer id) {
        String sql = "SELECT * FROM student Where id =" + id;
        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
   /* public List<Student> getStudentList() {
        try (Connection connection = Database.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            List<Student> studentList = new LinkedList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setBirthDate(resultSet.getDate("birth_daye").toLocalDate());

                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }*/
    public List<Student> studentList() {
       String sql = "select * from student";
       List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
       return list;
    }

   /* public int deleteStudent(Integer id) {
        try (Connection connection = Database.getConnection()) {
            String sql = String.format("delete from student where id = '%s'", id);

            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }*/
    public int deleteStudent(Integer id) {
        String sql = "delete from student where id =" + id;
        int n = jdbcTemplate.update(sql);
        return n;
    }

    public List<Student> getStudentBookInfoList(String studetTakenBook) {
          String sql ="select s.id as sid,sname as sName, b.name as bName"+
                      "from students_book sb inner join student as s on s.sid= sb.student.id "+
                  " inner join book as b on b.id = sb.book.id ";

          List<Student> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
       return  list;
    }

///   public List<StudentBook> getStudentBookInfoList() {
//        String sql = " select s.id as sId, s.name as sName, b.name as bName " +
//                " from student_book sb inner join student as s on s.id = sb.student_id " +
//                " inner join book as b on b.id = sb.book_id ";
//        List<StudentBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
//        return list;
//    }
}
