package com.soft1841;

import java.io.*;
import java.util.UUID;

/**
 * 文件复制操作 将uuid名字加入  重要操作要记住的
 * @ author 侯粤嘉
 * 2019.3.26
 */
public class FileCopy {
    public static void main(String[] args)throws IOException {
        //指定源文件
        File srcfile = new File("D:/1.jpg");
        String secfileName = srcfile.getName();
        //定点的位置
        int position = secfileName.indexOf(".");
        //取得源文件的扩展名
        String suffixName = secfileName.substring(position+1);
        //新的主文件名
        String newName = UUID.randomUUID().toString();
        //指定目标文件
        File destfile = new File("D:/java/"+newName+ "."+suffixName);
        //创建一个字节数组 大小为原文将长度 长度转换为int
        byte[] bytes = new byte[(int) srcfile.length()];
        //创建输入字节流
        InputStream in = new FileInputStream(srcfile);
        //将源文件读入字节数组
        in.read(bytes);
        //创建输出字节流
        OutputStream out = new FileOutputStream(destfile);
        //将字节流数组输出到目标文件
        out.write(bytes);
        //关闭输出输入流
        in.close();
        out.close();
    }
}
