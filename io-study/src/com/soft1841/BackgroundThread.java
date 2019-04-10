package com.soft1841;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BackgroundThread extends Thread {
    private JPanel BackgroudJPanel;

    public  void setBackgroudJPanel(JPanel BackgroudJPanel){
        this.BackgroudJPanel = BackgroudJPanel;
    }
    @Override
    public  void run(){

        Random random = new Random();
        while (true){
            //生成redrandom随机值
            int r = random.nextInt(256);
            //生成greenrandom随机值
            int g = random.nextInt(256);
            //生成bulerandom随机值
            int b = random.nextInt(256);
            BackgroudJPanel.setBackground(new Color(r,g,b));
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}