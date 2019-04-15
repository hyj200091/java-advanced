package com.week1;

/**
 * 绘图面板
 * @aurhor 侯粤嘉
 *2019.4.10
 */

import javax.swing.*;
import java.awt.*;

public class DrawLingFrame extends JFrame {
    public  DrawLingFrame(){
        init();
        setTitle("绘制彩色线段");
        setSize(1000,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public  void init(){
        getContentPane().setBackground(new Color(0,0,0));
        DrawLineThread drawLineThread = new DrawLineThread();
        drawLineThread.setFrame(this);
        new Thread(drawLineThread).start();

    }

    public static void main(String[] args) {
        new DrawLingFrame();
    }
}
