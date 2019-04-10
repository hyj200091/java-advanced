package com.soft1841;
/**
 * 在d盘下创建一个文件夹  文件夹里面有十个子目录
 * @author 侯粤嘉
 *2019.03.25
 */

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File path = new File("D:/java");
        if (!path.mkdirs()){
            path.mkdirs();
        }
        for (int i=1;i <=10;i++) {
            File path1 = new File(path + "/" + "chap" +i);
            if (!path1.exists()){
                path1.mkdirs();
            }
        }
    }
}
