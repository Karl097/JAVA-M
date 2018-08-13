package gui;

import javax.swing.*;
import java.awt.*;

//GridLayout，即网格布局器
public class GridLayoutDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("方向");
        f.setSize(400,300);
        f.setLocation(200,200);

        f.setLayout(new GridLayout(2,3));

        JButton b1=new JButton("绿谷出久");
        JButton b2=new JButton("爆豪胜己");
        JButton b3=new JButton("轰焦冻");
        JButton b4=new JButton("丽日御茶子");
        JButton b5=new JButton("欧尔麦特");
        JButton b6=new JButton("英格尼姆");

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
