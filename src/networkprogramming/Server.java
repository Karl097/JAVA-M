package networkprogramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//1. 服务端开启8888端口，并监听着，时刻等待着客户端的连接请求
public class Server {
    public static void main(String[] args) {
        try {
            //服务端打开端口8888
            ServerSocket ss=new ServerSocket(8888);

            //在8888端口监听，是否有链接请求
            System.out.println("监听在端口号：8888");
            Socket s=ss.accept();

           //启动线程发送消息
            new Thread(new Send(s)).start();
            //启动线程接收消息
            new Thread(new Receive(s)).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
