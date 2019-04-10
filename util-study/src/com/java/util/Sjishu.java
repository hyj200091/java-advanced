package com.java.util;
/**
 * 产生随机数 计算两点之间的距离
 * autho 侯粤嘉
 * 2019年3月13日
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

public class Sjishu {
    public static void main(String[] args) throws IOException {
        //产生随机数种子
        Random random = new Random();
        //生成两个点的坐标
        int x1 = random.nextInt(1024);
        int y1 = random.nextInt(768);
        int x2 = random.nextInt(1024);
        int y2 = random.nextInt(768);
        System.out.println("两个点的坐标为：("+x1+","+y1+")和("+x2+","+y2+")");
        //保留两位小数
        double result = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        DecimalFormat df = new DecimalFormat("#.00");
        String str = df.format(result);
        //指定图片大小和类型
        BufferedImage bufferedImage = new BufferedImage(1200, 970, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics graphics = bufferedImage.getGraphics();
        //获取字体
        Font font = new Font("方正克书皇榜体 简", Font.BOLD, 20);
        graphics.setFont(font);
        graphics.setColor(Color.GREEN);
        //绘制一个白色矩形
        graphics.fillRect(0, 0, 1200, 970);
        //控制台输出距离
        System.out.println("两点距离为" + str);
        //更改画笔颜色
        graphics.setColor(Color.BLACK);
        //绘制线段
        graphics.drawLine(x1, y1, x2, y2);
        //写上线段长度
        graphics.drawString(str,(x1+x2)/2,(y1+y2)/2);
        //输出图片,并指定文件路径
        File file = new File("D:/line.png");
        //获取输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节写到文件
        ImageIO.write(bufferedImage, "png", outputStream);
        //关闭输出流
        outputStream.close();
    }
}
