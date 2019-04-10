package Exercise3;
/**
 * BufferedStream 的运用
 * @author 侯粤嘉
 * 2019.4.3
 */

import java.io.*;
public class BufferedStreamTest {
    public static void main(String[] args) {
        //定义字符串数组
        String[] content = {"青春看起来如此完美,没空去浪费时间"};
        //创建文件对象
        File file = new File("word.txt");
        //创建FileOutputStream对象
        FileOutputStream  fos = null;
        //创建BufferedOutputStream对象
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try {
            //实例化FileOutputStream对象
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            //创建可以容乃1024字符节的缓冲区
            byte[] bContent = new byte[1024];
            //训话遍历数组
            for (int k=0;k<content.length;k++){
                //将遍历的数组转换为字节数组
                bContent = content[k].getBytes();
                //字节数组写入文件
                bos.write(bContent);
            }
            System.out.println("写入成功!\n");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //将BufferedOutputStream 与 FileOutputStreamm流关闭
                bos.close();
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            byte[] bContent = new byte[1024];
            //从文件中读取信息并存入字节数组中
            int len = bis.read(bContent);
            //输入文件数据
            System.out.println("文件中的信息是："+new String(bContent,0,len));
        }catch (    IOException e){
            e.printStackTrace();
        }finally {
            try {
                //将BufferedIutputStream 与 FileIutputStreamm流关闭
                bis.close();
                fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
