package com.soft1841;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 图片窗体程序
 * @author 侯粤嘉
 * 2019.3.26
 */
public class ImageFrame extends JFrame {
    private  JPanel topPanel;
    private JButton[] buttons;
    //imgLaben容纳图片
    private JLabel dateLabel;
    private JLabel imgLabel;
    //icon接受图片
    private  Icon icon;
    private JLabel originLabel;
    //构造方法 名字一样 不带返回值
    public ImageFrame(){
        init();
        setTitle("图片窗体");
        setSize(1000,600);
        //窗体自动居中
        setLocationRelativeTo(null);
        //窗口可见
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //设置布局 放置组件
    public void init(){
        topPanel = new JPanel();
        buttons = new JButton[5];
        for (int i = 0 ;i<5;i++){
            buttons[i] = new JButton("按钮"+i+1);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imgLabel = new JLabel();
        //读入本地图片到内存的字节数组
        File srcFile = new File("D:/1.jpg");
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
        imgLabel.setIcon(icon);
        add(imgLabel,BorderLayout.CENTER);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        dateLabel =new JLabel(date);
        add(dateLabel,BorderLayout.EAST);

        //绝对路径的获取
        File srcfile = new File("D:/java/1.jpg");
        String origin = srcfile.getAbsolutePath();
        originLabel =  new JLabel(origin);
        add(originLabel,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ImageFrame();
    }
}
