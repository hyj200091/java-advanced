package com.soft1841;

import java.io.*;

public class OutputEx {
    public static void main(String[] args)throws IOException {
        String str = "I love java";
        File file = new File("D://out1.txt");
        if (!file.exists()){
            file.createNewFile();
        }
//        //字节输出流
//        OutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(str.getBytes());
//        outputStream.close();
        //字符流流出  同时将运行结果追加
//        Writer writer = new FileWriter(file,true);
//        //将String转换成Char的字符串
//        writer.write(str.toCharArray());
//        writer.close();
        //打印流——包装流
        OutputStream out = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(out);
        printStream.print(str);
        System.out.println(str);
        out.close();
        printStream.close();
    }
}