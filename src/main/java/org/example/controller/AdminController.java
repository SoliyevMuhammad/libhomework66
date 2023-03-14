package org.example.controller;

import org.example.dto.Student;
import org.example.service.BookService;
import org.example.service.StudentService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Scanner;

@Controller
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    public void  start() {
        boolean b = true;
        while (b) {
            showMenu();
            switch (ScannerUtil.getAction()) {
            case 1 -> addBook();
            case 2 -> bookList();
            case 3 -> deleteBook();
            case 4 -> addStudent();
            case 5 -> studentList();
            case 6 -> deleteStudent();
            case 7 -> studentTakenBook();
            case 8 -> bookTakenHistory();
            case 0 -> b = false;
                default -> {
                    System.out.println("Mazgi!!!!");
                    showMenu();
                }
            }
        }
    }
    private void bookTakenHistory() {
    }
    private void studentTakenBook() {




    }
    private void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        Integer id = scanner.nextInt();
        studentService.deleteStudent(id);
    }
    private void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter birth date: ");
        String birthDate = scanner.nextLine();

        studentService.addStudent(name, surname, phone, birthDate);
    }
    private void studentList() {
        studentService.studentList();
    }
    private void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book id: ");
        Integer bookId = scanner.nextInt();

        bookService.deleteBook(bookId);
    }
    private void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter publish year: ");
        String publish_year = scanner.nextLine();

        System.out.print("Enter amount: ");
        Integer amount = scanner.nextInt();

        bookService.addBook(title, author, publish_year, amount);
    }
    private void bookList() {
        bookService.bookList();
    }
    public void showMenu() {
        System.out.println("ADMIN MENU");
        System.out.println("1. Add book");
        System.out.println("2. Book list");
        System.out.println("3. Delete book");
        System.out.println("4. Add student");
        System.out.println("5. Student List");
        System.out.println("6. Delete student");
        System.out.println("7. Student taken book");
        System.out.println("8. Book taken history");
        System.out.println("0. EXIT");
    }
}