package com.java.util;
/**
 * 随机数类的程序
 * author 侯粤嘉
 * 2019.3.12
 */
import java.util.Random;

public class   RandomDemo {
    public static void main(String[] args) {
        //随机生成一个5以内的随机数 包括5
        Random  random = new Random();
        //[o,bound)随机数的范围
        int num = random.nextInt(6);
        System.out.println(num);
    }
}
