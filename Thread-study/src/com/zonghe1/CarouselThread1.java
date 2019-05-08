package com.zonghe1;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CarouselThread1 implements Runnable {
    private String[] imgs = {"D:/yingliao/11.jpg", "D:/yingliao/22.jpg", "D:/yingliao/33.jpg"};
    private JLabel bgLabel;

    public  void setBgLabel(JLabel bgLabel){
        this.bgLabel = bgLabel;

    }
    @Override
    public void run() {
        int i = 0;
        int len = imgs.length;
        while (true) {
            try {
                //通过路径选择构建File对象
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i == len) {
                    i = 0;
                }
            } catch (IOException e) {
                System.out.println("IO异常");
            }
        }
    }
}
