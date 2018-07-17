package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStream1 {
    public static void main(String[] args) {
        try {
            //创建基于文件的输入流
            File f=new File("e:/Test/TestFile.txt");
            // 通过这个输入流，就可以把数据从硬盘，读取到Java的虚拟机中来，也就是读取到内存中
            FileInputStream fis=new FileInputStream(f);
            //创建字节数组，其长度是文件的长度
            byte all[]=new byte[(int)f.length()];
            //以字节流的形式读取文件的所有内容
            fis.read(all);
            for (byte b:all){
                System.out.print(b+"  ");
            }
            //每次使用完流都要进行关闭
            fis.close();


            File ff=new File("e:/Test/TestFile2.txt");
            FileOutputStream fos=new FileOutputStream(ff);
            //创建字节数组
            byte data[]={84,101,115,116,70,105,108,101,50};

            //把数据写入到输出流
            fos.write(data);
            //关闭
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
