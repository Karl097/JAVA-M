package gui;

import javax.swing.*;
import java.io.*;

//在上次关闭的位置启动窗口
//比如这次使用这个窗口，导致窗口被移动到了右下角。 关闭这个窗口，下一次再启动的时候，就会自动出现在右下角。
//        思路提示：
//        启动一个线程，每个100毫秒读取当前的位置信息，保存在文件中，比如location.txt文件。
//        启动的时候，从这个文件中读取位置信息，如果是空的，就使用默认位置，如果不是空的，就把位置信息设置在窗口上。
//        读取位置信息的办法： f.getX() 读取横坐标信息，f.getY()读取纵坐标信息。
public class GUIDemo2 {
    public static void main(String[] args) {
        //主窗体
        JFrame f=new JFrame("英雄联盟");
        //主窗体 设置大小
        f.setSize(400,300);
        //主窗体设置位置
        Point p=getPotion();
        if (p!=null)
            f.setLocation(p.x,p.y);
        else
            f.setLocation(200,200);
        //主窗体中组件设置为绝对位置
        f.setLayout(null);
        //按键按钮
        JButton b=new JButton("Victory");
        //同时设置组件的大小和位置
        b.setBounds(50,50,280,30);
        //把按钮添加 到主体中
        f.add(b);
        //关闭窗体的时候退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体可见
        f.setVisible(true);
        new Thread(new SavingPosition(f)).start();
    }
    static class Point{
        int x;
        int y;
    }
    public static Point getPotion(){
        File file=new File("e:/Test/location.txt");
        Point p=null;
        try (FileInputStream fis=new FileInputStream(file);
             DataInputStream dis=new DataInputStream(fis)){
            p=new Point();
            p.x=dis.readInt();
            p.y=dis.readInt();
        }catch (FileNotFoundException e){

        }catch (IOException e){
            e.printStackTrace();
        }
        return p;
    }

}
