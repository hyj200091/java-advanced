package com.soft1841.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口的基础练习 要记住的代码！！！
 * @author 侯粤嘉
 * 2019.03.19
 */
public class LiatTest {
    public static void main(String[] args) {
        //这是String的类型 其它的类型直接改<>里面的方法就可以了
        List<String > list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //直接输出list
        System.out.println(list);
        //通过for循环遍历集合
        int len = list.size();
        for (int i =0;i<len;i++){
            System.out.println(list.get(i));
        }
        //通过iTetator迭代器遍历集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //通过lambda表达式遍历集合
        list.forEach(s -> System.out.println(s));
    }
}
