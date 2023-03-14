package org.example.controller;

import org.example.service.LoginService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    private String menu = """
            -- MENU--
            1. Login
            0. Exit
            """;
    public void start() {
        boolean b = true;
        while (b) {
            System.out.println(menu);
            switch (ScannerUtil.getAction()) {
                case 1 -> getLogin();
                case 0 -> {
                    System.err.println("EXIT");
                    b = false;
                }
                default -> {
                    System.err.println("Not found NUMBER");
                    start();
                }
            }
        }
    }
    private void getLogin() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter phone: ");
            String phone = scanner.nextLine();

            loginService.login(phone);
    }
}
