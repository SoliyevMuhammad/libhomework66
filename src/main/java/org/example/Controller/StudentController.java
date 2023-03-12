package org.example.Controller;

import org.example.dto.Student;
import org.example.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    private Studentrepository studentrepository = new Studentrepository();
    /*public static void addStudent() {
        Student student = studentrepository.getProfileByPhone(phone);
        if(student != null){
            System.out.println(" bu foydalanuvchi bor");
        }

    }*/
/*    Scanner scanner = new Scanner(System.in);
        System.out.println("enter name ");
    String name  = scanner.next();
        System.out.println("enter surname ");
    String surname = scanner.next();
        System.out.println(" enter phone");
    String phone = scanner.next();

        studentController.addStudent(name,surname,phone);*/
}
