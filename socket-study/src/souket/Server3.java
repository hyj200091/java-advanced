package souket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 发送消息给客户端的服务器端口
 */
public class Server3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器已启动，端口号：10086.");
        while (true){
            Socket socket =serverSocket.accept();
            ServerThread3 serverThread3 = new ServerThread3(socket);
            new Thread(serverThread3).start();
        }
    }
}

class ServerThread3 implements Runnable{
    private Socket socket ;
    public ServerThread3 (Socket socket){
        this.socket =socket;
    }
    @Override
    public void run() {
        System.out.println("客户端："+socket.getInetAddress()+"连接成功！");
        String info = "本消息来自服务器通知";
        OutputStream outputStream =null;
        try {
            outputStream = socket.getOutputStream();
        }catch (IOException e){
            e.printStackTrace();
        }
        PrintStream printStream = new PrintStream(outputStream);
        printStream.print(info);
        printStream.close();
    }
}