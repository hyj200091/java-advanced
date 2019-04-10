package com.soft1841;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args)throws IOException {
        File file = new File("D:\\hello.txt");
        InputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);
        String result = scanner.nextLine();
        System.out.println(result);
    }
}
