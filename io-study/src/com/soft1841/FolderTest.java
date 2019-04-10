package com.soft1841;
/**
 * 输出指定文件下的所有图片类型文件
 * @author 侯粤嘉
 * 2019.4.1
 */

import java.io.File;


public class FolderTest {
    public static void main(String[] args) {
        //要遍历的路径
        String path = "D:/java/";
        //获取其file对象
        File file = new File(path);
        //遍历path下的文件和目录，放在File数组中
        File[] fs = file.listFiles();
        //遍历数组
        for (File f : fs) {
            //若非目录文件则打印
            if (!f.isDirectory()) {
                String namefile = f.getName();
                //取出后缀名
                int position = namefile.indexOf(".");
                String suffName = namefile.substring(position);
                //继续判断是否已.jpg和.png结尾
                if (suffName.equals(".jpg") || suffName.equals(".png")) {
                    System.out.println(f);
                }
            }
        }
    }
}