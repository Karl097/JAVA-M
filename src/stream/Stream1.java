package stream;

import java.io.*;

//缓存字符输入流 BufferedReader 可以一次读取一行数据
public class Stream1 {
    public static void main(String[] args) {
        File f=new File("e:/Test/Stream1.txt");

        try(FileReader fr=new FileReader(f);
            //缓存流必须创建在一个存在的流的基础上
            BufferedReader br=new BufferedReader(fr)){
            while (true){
                String line=br.readLine();
                if (null==line)
                    break;
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
