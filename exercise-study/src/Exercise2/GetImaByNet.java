package Exercise2;
/**
 * 读取网络图片
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetImaByNet extends Object implements Runnable {
    public static void main(String[] args) {
        GetImaByNet getImaByNet = new GetImaByNet();
        getImaByNet.run();
    }
    @Override
    public void run() {
        try {
            URL url = new URL("http://up.8desk.com/3/pic/2f/cc/63/2fcc6326ba6ce0051b6754e816d7b815.jpg");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5*1000);
            InputStream inStream = connection.getInputStream();
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer) ) != -1){
                out1.write(buffer,0,len);
            }
            inStream.close();
            byte[] date = out1.toByteArray();
            File imageFile = new File("D:\\5.jpg");
            OutputStream out2 = new FileOutputStream(imageFile);
            out2.write(date);
            out2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}