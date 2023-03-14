package org.example;

import org.example.config.Config;
import org.example.controller.LoginController;
import org.example.db.Database;
import org.example.db.InitDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Database.i1nitTable();
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        InitDatabase initDatabase = (InitDatabase) context.getBean("initDatabase");
        initDatabase.adminInit();
        LoginController loginController = (LoginController) context.getBean("loginController");
        loginController.start();



    }
}