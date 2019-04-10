package com.soft1841;

import java.io.*;
import java.util.Scanner;

/**
 * 控制台输入字符串 加入txt文件中
 * @author 侯粤嘉
 * 2019.3.26
 */
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入文字：");
        Scanner sc = new Scanner(System.in);
        File destfile = new File("D:/java/hello.txt");
        String result = sc.nextLine();
        char[] bytes = result.toCharArray();
        Writer out = new FileWriter(destfile);
        out.write(bytes);
        out.close();
    }
}
