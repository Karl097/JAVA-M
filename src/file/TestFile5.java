package file;

import java.io.File;
//同Testfile4的练习，要求遍历子文件夹
public class TestFile5 {
    File win=new File("c:/windows");

    //最大文件
    static File maxfile=null;
    //最小文件
    static File minfile=null;
    //最大文件大小
    static long max=0;
    //最小文件大小
    static long min=Integer.MAX_VALUE;

    //递归遍历
    public static void listfile(File file){
        if (file.isFile()){
            if(file.length()>max){
                max=file.length();
                maxfile=file;
            }
            if(file.length()!=0&&file.length()<min){
                min=file.length();
                minfile=file;
            }

        }
        if(file.isDirectory()){
            File fs[]=file.listFiles();
            if (fs!=null)
                for(File f:fs){
                listfile(f);
                }
        }

    }

    public static void main(String[] args) {
        File f=new File("c:/windows");
        listfile(f);

        System.out.println("最大的文件是："+maxfile.getAbsolutePath());
        System.out.println("最大文件大小是："+maxfile.length()+"字节");

        System.out.println("最小文件是："+minfile.getAbsolutePath());
        System.out.println("最小文件大小是："+minfile.length()+"字节");
    }
}
