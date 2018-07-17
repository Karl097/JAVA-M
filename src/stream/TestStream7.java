package stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//FileReader 是Reader子类，以FileReader 为例进行文件读取
//FileWriter 是Writer的子类，以FileWriter 为例把字符串写入到文件
public class TestStream7 {
    public static void main(String[] args) {
        File f=new File("e:/Test/TestFile.txt");
            // 创建基于文件的Reader
        try (FileReader fr=new FileReader(f)){
            // 创建字符数组，其长度就是文件的长度
            char all[]=new char[(int)f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            for (char c:all){
                System.out.println(c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        File ff=new File("e:/Test/Test.txt");
        //基于文件的writer
        try (FileWriter fw=new FileWriter(ff)){
            //以字符流的形式把数据写入到文件中
            String str="TestStream7";
            char data[]=str.toCharArray();
            fw.write(data);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
