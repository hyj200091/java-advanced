package com.zonghe1;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class TextThread implements Runnable {
    private  JTextArea jTextArea;


    public void setjTextArea(JTextArea jTextArea){
        this.jTextArea = jTextArea;
    }
    @Override
    public void run() {
        File file = new File("D:/new.txt");
        InputStream inputStream = null;
        byte[] bytes = new byte[(int) file.length()];
        try {
            inputStream = new FileInputStream(file);
            inputStream.read(bytes);
        }catch (IOException e){
            System.out.println("IO异常");
        }
        jTextArea.setText(new String(bytes));
    }
}
