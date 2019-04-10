package com.soft1841;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread extends Thread{
    private JLabel TimeJLabel;

    public  void setTimeJLabel(JLabel TimeJLabel){
        this.TimeJLabel = TimeJLabel;
    }
    @Override
    public void  run(){
        while (true){
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String date = format.format(new Date());
            TimeJLabel.setText(date);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}