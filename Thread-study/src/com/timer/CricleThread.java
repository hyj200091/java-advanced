package com.timer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class CricleThread implements  Runnable{

    public JPanel contentPanel;
    private JFrame frame;

    public void setFrame(JFrame  frame){
        this.frame = frame;
    }

    public  void setContentPanel(JPanel contentPanel){
        this.contentPanel= contentPanel;
    }

    int x = 1000;
    int y = 1000;
    int i = 0;

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Graphics graphics = frame.getGraphics();
            i = random.nextInt(20);
            graphics.drawOval(x / 2 - (i + 1) * 10, y / 2 - (i + 1) * 10, 10 + 20 * i, 10 + 20 * i);
        }
    }
}
