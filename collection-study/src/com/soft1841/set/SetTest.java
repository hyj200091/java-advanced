package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set接口的基础程序 要记住的
 * @author 侯粤嘉
 * 2019.3.22
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //重复的元素进不去的 只能是一个进去
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");
        System.out.println("直接输出set集合");
        System.out.println(set);
//        String s1 = new String("A");
//        String s2 = new String("B");
//        String s3 = new String("C");
//        String s4 = new String("A");
//        set.add(s1);
//        set.add(s2);
//        set.add(s3);
//        set.add(s4);
//        System.out.println(set);
        //用for循环遍历set集合
        System.out.println("用for循环遍历的结果：");
        Object[] arry = set.toArray();
        for (int i=0;i<arry.length;i++){
            System.out.println(arry[i]+" ");
        }
        //用Iterator迭代器输出
        System.out.println("用Itetator迭代器遍历的结果：");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        System.out.println("用lambda表达式遍历的结果：");
        //用lambda表达式输出
        set.forEach(s -> System.out.print(s+" "));
    }
}
