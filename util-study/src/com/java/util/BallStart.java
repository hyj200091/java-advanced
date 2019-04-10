package com.java.util;
/**
 * 输出历史十大球员信息 通过ArrayList 顺序表
 * @author 侯粤嘉
 * 2019.03.18
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BallStart {
    public static void main(String[] args) {
        List<Ball> nbaList = new ArrayList<>();
        nbaList.add(new Ball("乔丹", "飞人/神", 38.1, 6.2, 5.3));
        nbaList.add(new Ball("拉塞尔", "指环王", 15.1, 22.5, 4.3));
        nbaList.add(new Ball("贾巴尔", "天钩", 24.6, 11.2, 3.6));
        nbaList.add(new Ball("张伯伦", "篮球皇帝", 30.1, 22.9, 4.4));
        System.out.println("------NAB历史巨星------");
        System.out.println("姓名  绰号  得分  篮板  助攻");
        int len = nbaList.size();
        for (int i = 0; i < len; i++) {
            System.out.println(nbaList.get(i).getName() + " " + nbaList.get(i).getChao() + " " + nbaList.get(i).getDfeng()
                    + " " + nbaList.get(i).getLban() + " " + nbaList.get(i).getCgong());
            System.out.println();
        }
        System.out.println("用Iterator迭代器输出结果");
        Iterator<Ball> iterator = nbaList.iterator();
        while (iterator.hasNext()){
            Ball ball = iterator.next();
            System.out.println(ball.getName()+" "+ball.getChao()+" "+ball.getDfeng()+" "+ball.getLban()+" "+ball.getCgong());
        }
        System.out.println("Lambad表达式遍历输出结果");
        nbaList.forEach(ball -> System.out.println(ball.getName()+" "+ball.getChao()+" "+ball.getDfeng()+" "+ball.getLban()+" "+ball.getCgong()));
    }
}