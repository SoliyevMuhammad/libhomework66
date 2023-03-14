package org.example.controller;

import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.example.service.StudentService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class StudentController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    public void start() {
        boolean b = true;
        while (b) {
            showMenu();
            switch (ScannerUtil.getAction()) {
                case 1 -> bookList();
                case 2 -> takeBook();
                case 3 -> takenBook();
                case 4 -> returnBook();
                case 5 -> historyLibrary();
                case 6 -> orderBook();
                case 0 -> b = false;
                default -> {
                    System.out.println("Not found");
                    showMenu();
                }
            }
        }
    }
    private void orderBook() {
    }
    private void historyLibrary() {
    }
    private void returnBook() {
    }
    private void takenBook() {
    }
    private void takeBook() {
        ////  Enter book Id
        //
        //  (bitta student bir vaqtni o'zida 5ta kitob olishi mumkun.
        //   Ya'ni studentning olgan hali qaytarmagan kitoblar soni 5ga teng bo'lsa unga boshqa kitob berilmaydi.)
        //   Agar kitob qolmagan bo'lsa berilmasin.

//
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Enter book id");
        Integer id=scanner.nextInt();



        studentService.studenttakeBook(id);



    }
    private void bookList() {
        bookService.bookList();
    }
    public void showMenu() {
        System.out.println("-- STUDENT MENU--");
        System.out.println("1. Book list ");
        System.out.println("2. Take book ");
        System.out.println("3. Taken book ");
        System.out.println("4. Return book ");
        System.out.println("5. History library ");
        System.out.println("6. Order book ");
        System.out.println("0. Log Out");
    }
}