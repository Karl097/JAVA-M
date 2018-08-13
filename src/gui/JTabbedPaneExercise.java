package gui;

import javax.swing.*;
import java.io.*;

//参考eclipse的风格，借助TabbedPanel显示一个包下所有的java文件
public class JTabbedPaneExercise {
    public static void main(String[] args) {
        JFrame frame=new JFrame("file");
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);

        File file=new File("D:\\JAVA\\JAVA-M\\src\\file");

        showJava(file,frame);
    }
    public static void showJava(File file,JFrame frame){
        JTabbedPane tp=new JTabbedPane();
        int count=0;

        File fs[]=file.listFiles();
        for (File f:fs){
            JTextArea ta=new JTextArea();
            read(ta,f);

            JScrollPane sp=new JScrollPane(ta);

            tp.add(sp);
            ImageIcon icon=new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\j.png");
            tp.setIconAt(count,icon);//添加图标
            tp.setTitleAt(count++,f.getName());//名称
        }

        frame.setContentPane(tp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void read(JTextArea ta,File f){
//将文件内容读取到文本域中
        try (FileReader fr = new FileReader(f))
        {
            char[] all = new char[(int) f.length()];
            fr.read(all);
            ta.append(String.valueOf(all));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
