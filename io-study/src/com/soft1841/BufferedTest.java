package com.soft1841;
/**
 * 带缓冲流输入输出流
 * @author 侯粤嘉
 * 2019。4.4
 */

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        //定义字符串数组
        String[] content = {"莫要找失败的借口，只找成功的理由。"};
        //创建File类文件对象
        File file = new File("world.txt");
        try {
            FileWriter fw = new FileWriter(file);
            //创建BufferedWriter对象
            BufferedWriter bufw = new BufferedWriter(fw);
            //遍历数组
            for (int k =0;k<content.length;k++){
                //将字符串数组中的元素写入到磁盘中去
                bufw.write(content[k]);
                //将数组中的每一个元素以单位的形式写入文件
            }
            bufw.close();
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            //创建FileReader类对象
            FileReader fr = new FileReader(file);
            //创建BufferedReader对象
            BufferedReader  bufr = new BufferedReader(fr);
            String s = null;
            int i=0;
            //如果文件的文本行数不为null，则进入循环
            while ((s = bufr.readLine()) !=null){
                i++;
                System.out.println("第"+i+"行："+s);
            }
            bufr.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
