package com.java.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * 随机颜色练习
 * @author 侯粤嘉
 * 2019.3.12
 */
public class RandomColor {
    public static void main(String[] args) throws IOException {
        //随机种子
        Random random = new Random();
        //生成redrandom随机值
        int redRandom = random.nextInt(256);
        //生成greenrandom随机值
        int greenRandom = random.nextInt(256);
        //生成bulerandom随机值
        int buleRandom = random.nextInt(256);
        System.out.println("R:" + redRandom + ",G" + greenRandom + ",B" + buleRandom);
        //开始用随机色值绘制图片
        //
        BufferedImage bufferedImage = new BufferedImage(120, 40, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置字体
        Font font = new Font("微软雅黑", Font.BOLD, 16);
        g.setFont(font);
        //设置画笔颜色 使用随机生成的颜色
        Color color = new Color(redRandom, greenRandom, buleRandom);
        g.setColor(color);
        //开始绘制,充满图片缓冲区
        g.fillRect(0, 0, 120, 40);
        //绘制文字
        g.setColor(Color.BLACK);
//        g.drawString("验证码",40,20);


        ArrayList<Object> array = new ArrayList<Object>();
        for (int i = 0; i < 4; i++) {
            int choice = random.nextInt(3);
            switch (choice) {
                case 0:
                    int num = random.nextInt(9);
                    array.add(num);
                    break;
                case 1:
                    int num2 = random.nextInt(25) + 65;
                    char low = (char) num2;
                    array.add(low);
                    break;
                case 2:
                    int num3 = random.nextInt(25) + 97;
                    char high = (char) num3;
                    array.add(high);
                    break;
                default:
                    break;
            }
        }
        System.out.println("随机验证码为：");
        for (Object object : array) {
            System.out.print(object);
        }

        //输出图片  从内层输出到外层
        //指定文件路径
        File file = new File("D:/code.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流写到D盘文件
        ImageIO.write(bufferedImage, "jpg", outputStream);
        //写完就要关闭这个流 不然有隐患的
        outputStream.close();
    }
}
