package com.soft1841;
/**
 * 模拟交通中红绿灯得变化
 * @author 侯粤嘉
 * 2019.4.15
 */

import javax.swing.*;

public class TurnColor extends Thread {
    private JLabel imgLabel;

    public TurnColor(JLabel imgLabel){
        this.imgLabel = imgLabel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(new ImageIcon(TrafficLights.class.getResource("/img/YEllOW.png"))); // 黄灯
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(new ImageIcon(TrafficLights.class.getResource("/img/Red.png"))); // 红灯
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(new ImageIcon(TrafficLights.class.getResource("/img/Green.png"))); // 绿灯
        }
    }
}
