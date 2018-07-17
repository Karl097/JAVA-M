package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.module.FindException;

//标准的关闭流的方式
//1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
//        2. 在finally关闭之前，要先判断该引用是否为空
//        3. 关闭的时候，需要再一次进行try catch处理
public class TestStream5 {
    public static void main(String[] args) {
        File f=new File("e:/Test/TestFile.txt");
        FileInputStream fis=null;

        try {
            fis=new FileInputStream(f);
            byte all[]=new byte [(int)f.length()];

            fis.read(all);
            for (byte b:all){
                System.out.println(b);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //在这里关闭流
            if (fis != null)
            try {
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
