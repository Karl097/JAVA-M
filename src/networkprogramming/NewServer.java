package networkprogramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//当从scanner读取到消息，发给Server服务端，服务端用这个消息到表dictionary中找到对应的相应，返回出去。 看上去就像在自动回应一样。
//        如果一个recieve有多条response，则随机返回一条
public class NewServer {
    public static void main(String[] args) {
        try {
            //服务端打开端口8888
            ServerSocket ss = new ServerSocket(8888);

            //在8888端口监听，是否有链接请求
            System.out.println("监听在端口号：8888");
            Socket s = ss.accept();

            //打开输入流
            InputStream is = s.getInputStream();
            //把输入流封装在DataInputStream中
            DataInputStream dis = new DataInputStream(is);

            //打开输出流
            OutputStream os = s.getOutputStream();
            //把输出流封装在DataOutputStream
            DataOutputStream dos = new DataOutputStream(os);

            while (true) {
                //读取客户端发来的内容
                String msg= dis.readUTF();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "admin"); Statement state = c.createStatement();) {

                    String str = "select * from dictionary where receive="+"'"+msg+"'";

                    ResultSet rs = state.executeQuery(str);

                    List<String> response=new ArrayList<>();
                    while (rs.next()){
                        response.add(rs.getString(3));
                    }
                    System.out.println(response);
                    Collections.shuffle(response);
                    dos.writeUTF(response.get(0));
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
