package week1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static java.awt.SystemColor.info;

public class UDPServer {
    public static void main(String[] args)throws IOException {
        /*
        *接受客户端消息
         */
        //1创建指定服务器端DatagramSocket  指定端口
        DatagramSocket socket  = new DatagramSocket(8888);
        //2 创建数据报，用于接受客户端发送的数据
        byte[] data = new byte[1024];//创建字节数组 只定接受的数据包的大小
        DatagramPacket packet = new DatagramPacket(data,data.length);
        //3 接受客户端发送的数据
        System.out.println("****服务器已经启动，等待客户端发送数据");
        socket.receive(packet);//此方法在接受到数据报之前会一直阻塞
        //4读取数据
        String info = new String(data,0,packet.getLength());
        System.out.println("我是服务器，客户端说："+info);


        /*
        *向客户端发送消息
         */
        //1定义客户端的地址 端口号 数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "欢迎您！".getBytes();
        //2创建数据报 包含响应的数据消息
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
        //3响应客户端
        socket.send(packet2);
        //4关闭资源
        socket.close();
    }
}
