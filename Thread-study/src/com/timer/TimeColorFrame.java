package com.timer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 时钟界面
 * @author 侯粤嘉
 * 2019.4.16
 */
public class TimeColorFrame extends JFrame {
    private Timer timer;
    private TimerTask clockTask;
    private JLabel dataLabel;

    public TimeColorFrame(){
            init();
            setTitle("Timer定时器练习");
            setSize(600, 400);
            setLocation(1320,600);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init(){
        Font font = new Font("微软雅黑",Font.BOLD,30);
        dataLabel = new JLabel();
        dataLabel.setFont(font);
        //创建JPanel对象得同时 将背景图绘制上去
        JPanel jPanel = new JPanel(){
            protected  void paintComponent(Graphics g){
                try {
                    Image bg = ImageIO.read(new File("D:\\55.jpg"));
                    g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,200));
        add(jPanel);
        clockTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);

                dataLabel.setText(timeString);
                jPanel.add(dataLabel);
                if(timeString.equals("2019-04-16 09:15:40")){
                    JOptionPane.showMessageDialog(jPanel, "时间到~~");
                    this.cancel();
                }

            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(clockTask, 0, 1000);
    }

    public static void main(String[] args) {
        new TimeColorFrame();
    }
}