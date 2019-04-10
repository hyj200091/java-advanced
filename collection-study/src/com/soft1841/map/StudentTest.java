package com.soft1841.map;

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> list1  = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        list1.add(new Student(3307,"侯粤嘉"));
        list1.add(new Student(3319,"许源"));
        list2.add(new Student(3332,"王欢乐"));
        list2.add(new Student(3335,"孟妮"));
        Map<String,List<Student>> map = new HashMap<>();
        map.put("男",list1);
        map.put("女",list2);
        System.out.println("********按性别输出的集合的结果********");
        Iterator<Map.Entry<String,List<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<Student>> entry = iterator.next();
            System.out.println(entry.getKey());
            List<Student> list = entry.getValue();
            list.forEach(stud ->{
                System.out.println(stud.getNumber()+"\t"+stud.getName());
                System.out.println();
            } );
        }
    }
}
