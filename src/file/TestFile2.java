package file;

import java.io.File;
import java.util.Date;

public class TestFile2 {
    public static void main(String[] args) {
        File f1=new File("e:/Test/TestFile.txt");
        System.out.println("当前文件是："+f1);

        //判断文件是否存在
        System.out.println("文件是否存在："+ f1.exists());

        //判断是否是文件夹
        System.out.println("是否是文件夹："+f1.isDirectory());

        //判断是否是文件
        System.out.println("是否是文件："+f1.isFile());

        //获取文件长度
        System.out.println("该文件的长度是："+f1.length());

        //获取文件的最后修改时间
        long time=f1.lastModified();
        Date d=new Date(time);
        System.out.println("文件最后修改时间是："+d);
        //设置文件最后修改时间为：19701/1 08;00:00
        f1.setLastModified(0);

        //文件重命名
        File f2=new File("e:/Test/TestFile.txt");
        f1.renameTo(f2);
        System.out.println("文件现在的名称是："+f2);
    }
}
