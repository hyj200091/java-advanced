package com.timer;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CricleDemo  extends JFrame {


    public JPanel contentPanel;

    public  CricleDemo(){
        init();
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        Font font = new Font("微软雅黑",Font.BOLD,30);
        setFont(font);
        contentPanel = new JPanel();
        add(contentPanel, BorderLayout.CENTER);
        getContentPane().setBackground(new Color(0,0,0));
        CricleThread thread = new CricleThread();
        thread.setFrame(this);
        new Thread(thread).start();
        new Thread(thread).start();
        thread.setContentPanel(contentPanel);
    }
    public static void main(String[] args){
        new CricleDemo();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,0,5000);
    }
}
