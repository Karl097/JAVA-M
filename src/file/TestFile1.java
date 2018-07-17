package file;

import java.io.File;

public class TestFile1 {
    public static void main(String[] args) {
        File f1=new File("e:/Test");
        System.out.println("f1的绝对路径："+f1.getAbsolutePath());

        File f2=new File("Test.txt");
        System.out.println("f2的绝对路径："+f2.getAbsolutePath());

        File f3=new File(f1,"Test.txt");
        System.out.println("f3的绝对路径："+f3.getAbsolutePath());
    }
}
