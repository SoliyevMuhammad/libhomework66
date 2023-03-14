package org.example.util;

import java.util.Scanner;

public class ScannerUtil {
    public static int getAction() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter action: ");
            try {
                int n = scanner.nextInt();
                return n;
            } catch (RuntimeException e) {
                System.out.println("Xoto kiritildi. To'g'ri yozing Mazgi.");
            }
        }
    }
}
