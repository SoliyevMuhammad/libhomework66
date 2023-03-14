package org.example.service;

import org.example.controller.AdminController;
import org.example.controller.StudentController;
import org.example.dto.Student;
import org.example.enums.GeneralStatus;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentController studentController;
    @Autowired
    private AdminController adminController;
    public void login(String phone) {
     Student student = studentRepository.getStudentByPhone(phone);

     if(student == null) {
         System.out.println("Phone is incorrect!");
         return;
     }
     if (student.getStatus().equals(GeneralStatus.STUDENT)) {
         studentController.start();
     } else if (student.getStatus().equals(GeneralStatus.ADMIN)) {
         adminController.start();
     }else {
         System.out.println("We don't have you!");
     }

    }
}
