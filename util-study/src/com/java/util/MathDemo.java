package com.java.util;

/**
 * 数学类Math的程序
 * author 侯粤嘉
 */
public class MathDemo {
    public static void main(String[] args) {
        int num =5 ;
        System.out.println(Math.sqrt(num));
        //%。2f意思是保留小数点后的两位  %。3f就是保留三位小数
        System.out.printf("%.2f",Math.sqrt(num));
    }
}
