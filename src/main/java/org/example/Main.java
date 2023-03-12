package org.example;

import org.example.Config.Config;
import org.example.Controller.AdminController;
import org.example.Controller.AuthController;
import org.example.db.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AdminController adminController = (AdminController) context.getBean("adminController");
        adminController.start();

    }
}