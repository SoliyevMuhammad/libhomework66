package org.example.Controller;

import org.example.db.Database;
import org.example.dto.Student;
import org.example.service.Authservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AuthController {
    @Autowired
   private Authservice authservice ;

    public  void  start(){
        Database.init();
        boolean b = true;
        while (b){
            menyu();
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n){
                case 1 -> login();
                case 2 -> Exit();
            }

        }


    }

    private void Exit() {
        System.out.println(" Menyu ");

    }

    public void  login(){
        System.out.println(" Enter name ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("enter password ");
        String phone  = scanner.next();

        authservice.login(name,phone);


    }

    public void menyu(){
        System.out.println("1.Login\n" +
                "0.Exit");
    }

}
