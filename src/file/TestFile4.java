package file;

import java.io.File;
/*
一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。

        遍历这个目录下所有的文件(不用遍历子目录)

        找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名

        注: 最小的文件不能是0长度
*/
public class TestFile4 {
    public static void main(String[] args) {
        File win=new File("c:/windows");

        //建立文件数组
        File file[]=win.listFiles();
        //最大文件
        File maxfile=null;
        //最小文件
        File minfile=null;
        //最大文件大小
        long max=0;
        //最小文件大小
        long min=Integer.MAX_VALUE;


        for (int i=0;i<file.length;i++){
            if(file[i].isDirectory())
                continue;
            if (file[i].length()>max){
                max=file[i].length();
                 maxfile=file[i];
            }
            if (file[i].length()<min&&file[i].length()!=0) {
                min = file[i].length();
                 minfile = file[i];
            }
        }

        System.out.println("最大的文件是："+maxfile);
        System.out.println("最大文件大小是："+max+"字节");

        System.out.println("最小文件是："+minfile);
        System.out.println("最小文件大小是："+min+"字节");
}
}
