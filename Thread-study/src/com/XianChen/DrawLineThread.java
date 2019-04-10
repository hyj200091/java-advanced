package com.XianChen;
/**
 * 绘图线程程序
 * @author 侯粤嘉
 * 2019.4.10
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawLineThread implements Runnable {
    int x =200;
    int y = 200;
    private JFrame frame;
    private Color[] colors = {Color.WHITE,Color.CYAN,Color.BLUE,Color.GREEN,
            Color.ORANGE,Color.YELLOW,Color.RED,Color.PINK,
    Color.LIGHT_GRAY};

    public void setFrame(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Graphics graphics = frame.getGraphics();
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(350, 450, 500, y);
            y += 10;
            if (y > 600) {
                y = 100;
            }
        }
    }
}
