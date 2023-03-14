package org.example.service;

import org.example.dto.Book;
import org.example.dto.Student;
import org.example.dto.StudentsBook;
import org.example.enums.GeneralStatus;
import org.example.repository.BookRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;
    public void addStudent(String name, String surname, String phone, String birthDate) {
        Student exists = studentRepository.getStudentByPhone(phone);
        if (exists != null) {
            System.out.println("Student phone exists.");
        }

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setPhone(phone);
        student.setBirthDate(LocalDate.parse(birthDate));
        student.setStatus(GeneralStatus.STUDENT);

        int n = studentRepository.save(student);

        if (n != 0) {
            System.out.println("Student added successfully");
            return;
        } else {
            System.out.println("ERROR");
        }
    }

    public void studentList() {
        List<Student> studentList = studentRepository.studentList();
        if (studentList == null) {
            System.out.println("No student yet");
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void deleteStudent(Integer id) {
        Student exists = studentRepository.getStudentById(id);
        if (exists == null) {
            System.out.println("Not found .");
        }
        int n = studentRepository.deleteStudent(id);
        if (n != 0) {
            System.out.println("Deleted student");
        }
    }

    public void studenttakenBook(String studetTakenBook) {
//        List<Student> studentList = studentRepository.studentList();
//        if (studentList == null) {
//            System.out.println("No student yet");
//        }
//        for (Student student : studentList) {
//            System.out.println(student);
//        }


    }

    ////  Enter book Id
    //
    //  (bitta student bir vaqtni o'zida 5ta kitob olishi mumkun.
    //   Ya'ni studentning olgan hali qaytarmagan kitoblar soni 5ga teng bo'lsa unga boshqa kitob berilmaydi.)
    //   Agar kitob qolmagan bo'lsa berilmasin.

    public void studenttakeBook(Integer id) {
        Book exist =bookRepository.getBookById(id);
        if (exist==null) {
            System.out.printf("Book not exist");
        }
        StudentsBook studentsBook1=new StudentsBook();
        studentsBook1.setId(id);
        bookRepository.takebook(id);


    }
}
