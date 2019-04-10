package com.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * List接口的练习
 * @author  侯粤嘉
 * 2019.03.18
 */
public class ListTest {
    public static void main(String[] args) {
        //创建一个
        List<String> list = new ArrayList<>();
        //增加三个元素
        list.add("java");
        list.add("HTML");
        list.add("高数");
        list.add("高数");
        //用util的
        int length = list.size();
        System.out.println(length);
        Random random = new Random();
        int index = random.nextInt(length);
        System.out.println(index);
//        System.out.println(list.get(length));
        //输出所有类型的元素
        for (int i=0;i<length ;i++){
            System.out.println(list.get(i));
        }
}
}
