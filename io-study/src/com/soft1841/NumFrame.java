package com.soft1841;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NumFrame extends JFrame {
    private JPanel BackgroudJPanel;
    private BorderLayout borderLayout;
    private JLabel NumJLabel,TimeLabel,imgJlabel;
    private  Icon icon;


    public NumFrame(){
        init();
        setTitle("产生随机数窗体");
        setLocationRelativeTo(null);
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        BackgroudJPanel = new JPanel();
        NumJLabel = new JLabel();
        imgJlabel = new JLabel();
        //读入本地图片到内存的字节数组
        File srcFile = new File("D:\\1.jpg");
        InputStream in;
        byte[] bytes = null;
        try {
            in = new FileInputStream(srcFile);
            bytes = new byte[(int) srcFile.length()];
            in.read(bytes);
        }catch (IOException e){
            System.out.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        imgJlabel.setIcon(icon);

        Font font = new Font("微软雅黑",Font.BOLD,30);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        TimeLabel = new JLabel(date);
        TimeLabel.setFont(font);
        NumJLabel.setFont(font);

        add(BackgroudJPanel,BorderLayout.CENTER);
        add(imgJlabel,BorderLayout.EAST);
        add(NumJLabel,BorderLayout.NORTH);
        add(TimeLabel,BorderLayout.SOUTH);

        BackgroundThread backgroundThread = new BackgroundThread();
        ImageThread imageThread = new ImageThread();
        NumThread numThread = new NumThread();
        TimeThread timeThread = new TimeThread();

        backgroundThread.setBackgroudJPanel(BackgroudJPanel);
        imageThread.setimgLabel(imgJlabel);
        numThread.setNumJLabel(NumJLabel);
        timeThread.setTimeJLabel(TimeLabel);


        numThread.start();
        timeThread.start();
        backgroundThread.start();
        imageThread.start();

    }

    public static void main(String[] args) {
        new NumFrame();
    }

}
