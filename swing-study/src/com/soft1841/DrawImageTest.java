package com.soft1841;
/**
 * 绘制图像
 * @author 侯粤嘉
 * 2019.4.11
 */

import javax.swing.*;
import java.awt.*;

public class DrawImageTest extends JFrame {
    public DrawImageTest(){
        this.setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置窗体面板为绘画面板对象
        add(new CanvasTest());
        this.setTitle("绘制图像");
    }

    public static void main(String[] args) {
        //使窗体可见
        new DrawImageTest().setVisible(true);
    }
    class CanvasTest extends Canvas{
        //创建画布
        public  void paint(Graphics g){
            super.paint(g);
            Graphics2D graphics2D = (Graphics2D) g;
            //获取图片资源
            Image img = new ImageIcon(this.getClass().getResource("/img/4.jpg")).getImage();
            //显示图片
            graphics2D.drawImage(img,0,0,this);
        }
    }
}
