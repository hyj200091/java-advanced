package com.soft1841.map;
import java.util.*;

public class ComplexTest {
    public static void main(String[] args) {
        List<Complex> list = new ArrayList<>();
        list.add(new Complex(1,"大众","德国",13.6));
        list.add(new Complex(2,"宝骏730","中国",15.3));
        list.add(new Complex(3,"北京现代","中国",17.9));
        //直接输出list
        System.out.println("直接输出list结果为：");
        System.out.println(list);
        //通过for循环遍历集合
        int len = list.size();
        System.out.println("----通过for循环遍历集合----");
        for (int i = 0;i<len;i++){
            System.out.print(list.get(i).getId()+" "+list.get(i).getName()+" "+list.get(i).getOrigin()+" "+list.get(i).getPrice());
            System.out.println();
        }
        //通过iterator迭代器遍历集合
        System.out.println("----通过iterator迭代器遍历集合----");
        Iterator<Complex> iterator = list.iterator();
        while (iterator.hasNext()){
            Complex complex = iterator.next();
            System.out.print(complex.getId()+""+complex.getName()+" "+complex.getOrigin()+" "+complex.getPrice());
            System.out.println();
        }
        //通过lambda表达式遍历集合
        System.out.println("----通过lambda表达式遍历集合----");
        list.forEach(complex -> System.out.println(complex.getId()+""+complex.getName()+" "+complex.getOrigin()+" "+complex.getPrice()));
        System.out.println();
        Map<String, List<Complex>> map = new HashMap<>();
        List<Complex>  list1 = new ArrayList<>();
        List<Complex>  list2 = new ArrayList<>();
        list2.add(new Complex(1,"大众","德国",13.6));
        list1.add(new Complex(2,"宝骏730","中国",15.3));
        list1.add(new Complex(3,"北京现代","中国",17.9));
        map.put("国产汽车：",list1);
        map.put("进口汽车：",list2);
        System.out.println("------用map与list结合按照出产地输出的集合结果------");
        Iterator<Map.Entry<String,List<Complex>>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String,List<Complex>> entry = iterator1.next();
            System.out.println(entry.getKey());
            List<Complex> list3 = entry.getValue();
            list3.forEach(complex -> {
                System.out.print(complex.getId()+"\t"+complex.getName()+" "+complex.getOrigin());
                System.out.println();
            });
        }
        Set<Complex> set = new TreeSet<>();
        set.add(new Complex(12," 福特","德国",15.8));
        set.add(new Complex(18," 奔驰","日本",14.5));
        set.add(new Complex(14," 比亚迪","中国",12.3));
        Iterator<Complex> iterator2 = set.iterator();
        System.out.println("Set集合中的元素输出为");
        while (iterator2.hasNext()){
            System.out.println(iterator2.next()+" ");
        }
    }
}
