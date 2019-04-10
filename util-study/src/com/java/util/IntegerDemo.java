package com.java.util;

/**
 * integer类的练习
 * @author 侯粤嘉
 * 2019.3.12
 */
public class IntegerDemo {
    public static void main(String[] args) {
        int num = 31;
        //调用integet类的方法，将num进行进制转换
        String str1 = Integer.toBinaryString(num);
        System.out.println("二进制" + str1);
        String str2 = Integer.toHexString(num);
        System.out.println("十六进制" + str2);
        String str3 = Integer.toOctalString(num);
        System.out.println("八进制" + str3);
        String str4 = Integer.toString(num);
        System.out.println("十五进制" + str4);
        System.out.println("--------分割线以下是自定义转换---------");
        //调用自定义的进制转换方法
        System.out.println("转化为八进制：" + convert(num, 8));
    }

    public static String convert(int num, int radix) {
        //创建一个StrigBuffer，用来存放结果字符串
        StringBuffer stringBuffer = new StringBuffer();
        //被除数不为0  就循环
        while (num !=0){
            //求出余数
            int remainder = num % radix;
            //将余数转换成字符串 加入stringBuffer
            stringBuffer.append(String.valueOf(remainder));
            //更新被除数的商
            num = num/radix;
        }
        //将结果串取返回
        return stringBuffer.reverse().toString();
    }
}
