package com.soft1841;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@author 侯粤嘉
 * 2019.03.25
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        System.out.println(date);
        //创建一个D盘更目录
        File path = new File("D:/time_"+date);
        if (!path.exists()){
            path.mkdirs();
        }
        //创建一个文件夹
        File file = new File(path + "/" + "hello_"+date);
        if (!file.exists()){
                file.createNewFile();
            }
        }
    }