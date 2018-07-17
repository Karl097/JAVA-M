package stream;

import java.io.*;

//设计一个方法，用于移除Java文件中的注释
//
//public void removeComments(File javaFile)
//
//
//        比如，移出以//开头的注释行
//
//        File f = new File("d:/JAVA/JAVA-M/src/Stream/Test.java");
//        System.out.println("当前文件是：" +f);
////文件是否存在
//        System.out.println("判断是否存在："+f.exists());
////是否是文件夹
//        System.out.println("判断是否是文件夹："+f.isDirectory());
public class Stream3 {
    public static void main(String[] args) {
        File javaFile=new File("d:/JAVA/JAVA-M/src/Stream/Test.java");
        System.out.println(javaFile.exists());
        System.out.println(javaFile.isDirectory());
        removeComments(javaFile);
    }
    public static void removeComments(File javaFile){
        StringBuffer sb = new StringBuffer();
        //读取内容
        try (FileReader fr=new FileReader(javaFile);
             BufferedReader br=new BufferedReader(fr)){
            while (true) {
                String line = br.readLine();
                String start = "//";
                if (null == line) {
                    break;
                }
                //判断是否是“//”开头
                if (!line.trim().startsWith(start)) {//使用trim()去掉前面的空格
                    sb.append(line).append("\r\n");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try (FileWriter fw=new FileWriter(javaFile);
            PrintWriter pw=new PrintWriter(fw)){
            pw.write(sb.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
