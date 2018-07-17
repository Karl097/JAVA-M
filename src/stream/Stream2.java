package stream;

import java.io.*;

//PrintWriter 缓存字符输出流， 可以一次写出一行数据
//有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush
public class Stream2 {
    public static void main(String[] args) {
        File f=new File("e:/Test/Stream2.txt");

        try(FileWriter fw=new FileWriter(f);
            //缓存流必须创建在一个存在的流的基础上
            PrintWriter pw=new PrintWriter(fw)){
            pw.println("garen kill teemo");
            pw.println("teemo revive after 1 minutes");
            //强制把缓存中的数据写入硬盘，无论缓存是否已满
            pw.flush();
            pw.println("teemo try to kill garen, but killed again");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
