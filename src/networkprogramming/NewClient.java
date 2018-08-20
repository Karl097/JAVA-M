package networkprogramming;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//当从scanner读取到消息，发给Server服务端，服务端用这个消息到表dictionary中找到对应的相应，返回出去。 看上去就像在自动回应一样。
//        如果一个recieve有多条response，则随机返回一条
public class NewClient {
    public static void main(String[] args) {
        try {
            Socket s=new Socket("127.0.0.1",8888);

            //打开输出流
            OutputStream os=s.getOutputStream();
            //把输出流封装在DataOutputStream
            DataOutputStream dos=new DataOutputStream(os);

            //打开输入流
            InputStream is =s.getInputStream();
            //把输入流封装在DataInputStream中
            DataInputStream dis = new DataInputStream(is);

            while (true){
                //从控制台读取
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                //发送
                dos.writeUTF(str);

                //读取服务端发来的内容
                String msg= dis.readUTF();
                //打印
                System.out.println(msg);
                System.out.println();
            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
