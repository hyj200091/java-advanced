package com.soft1841.set;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * 用迭代器输出Set集合 并且TreeSet自动排序
 * @author 侯粤嘉
 * 2019.03.19
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(-5);
        set.add(-7);
        set.add(3);
        set.add(6);
        set.add(10);
        Iterator<Integer> iterator = set.iterator();
        System.out.println("Set集合中的元素");
        while (iterator.hasNext()){
            System.out.println(iterator.next()+" ");
        }
    }
}
