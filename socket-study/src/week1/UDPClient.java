package week1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args)throws IOException {
        /*
        *向服务器端发送数据
         */
        //1定义服务器的地址 端口号 数据
        InetAddress address  = InetAddress.getByName("localhost");
        int port = 8888;
        byte[] data = "用户名：admin：密码：123".getBytes();
        //2创建数据报 包含发送的数据消息
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        //3创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //4向服务器端发送数据报
        socket.send(packet);


        /*
        *接受服务器响应的数据
         */
        //1 创建数据报 用于接受服务器端口响应的数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data2,data.length);
        //2接受服务器响应的数据
        socket.receive(packet1);
        //3读取数据
        String reply = new String(data2,0,packet1.getLength());
        System.out.println("我是客户端，服务器说："+reply);
        //4关闭资源
        socket.close();
    }
}
