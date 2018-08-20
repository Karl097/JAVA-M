package networkprogramming;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

//2. 客户端知道服务端的ip地址和监听端口号，发出请求到服务端
//一旦建立了连接，服务端和客户端就可以通过Socket进行通信了
public class Client {
    public static void main(String[] args) {
        GUIServer chat=new GUIServer();

        try {
            //连接到本机客户端
            Socket s=new Socket("127.0.0.1",8888);

            //启动线程发送消息
            new Thread(new Send(s)).start();
            //启动线程接收消息
            new Thread(new Receive(s)).start();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
