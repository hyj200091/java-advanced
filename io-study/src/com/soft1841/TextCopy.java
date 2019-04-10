package com.soft1841;

import java.io.*;

/**
 * 文本复制操作
 * @ author 侯粤嘉
 * 2019.3.26
 */
public class TextCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:/hello.txt");
        File destFile = new File("D:/java/hello副本.txt");
        FileReader in = new FileReader(srcFile);
        char[] chars = new char[(int) srcFile.length()];
        in.read(chars);
        Writer out = new FileWriter(destFile);
        out.write(chars);
        out.close();
        in.close();
    }
}
