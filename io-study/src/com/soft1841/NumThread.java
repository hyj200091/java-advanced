package com.soft1841;

import javax.swing.*;
import java.util.Random;

public class NumThread extends Thread {
    private JLabel NumJLabel;

    public void setNumJLabel(JLabel NumJLabel ){
        this.NumJLabel = NumJLabel;
    }
    @Override
    public  void run(){
        Random random  = new Random();
        while (true){
            int num = random.nextInt(100);
            NumJLabel.setText(String.valueOf(num));
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
