package com.soft1841;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageThread extends Thread{
    private Icon icon;
    private JLabel imgLabel;

    public void setimgLabel(JLabel imgJLabel ){
        this.imgLabel = imgJLabel;
    }

    @Override
    public  void run(){
        //读入本地图片到内存的字节数组
        File srcFile = new File("D:\\img\\img");
        InputStream in;
        while (true){
            byte[] bytes = null;
            try {
                in = new FileInputStream(srcFile);
                bytes = new byte[(int) srcFile.length()];
                in.read(bytes);
            }catch (IOException e){
                System.out.println("IO异常");
            }
            imgLabel.setText(String.valueOf(bytes));
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
