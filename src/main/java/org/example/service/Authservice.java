package org.example.service;

import org.example.Controller.AdminController;
import org.example.Controller.MainController;
import org.example.db.Database;
import org.example.dto.Student;
import org.example.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Authservice {
     @Autowired
     private Studentrepository studentrepository = new Studentrepository();
     @Autowired
     private AdminController adminController = new AdminController();
     @Autowired
     private MainController mainController = new MainController();

    public void login(String name, String phone) {
      Student student = studentrepository.getProfileByPhoneAndPassword(name,phone);
    if(student.getName().equals("ravshan") && student.getPhone().equals("222222")){
        adminController.start();
    } else {
      mainController.start();
    }

    }


}
