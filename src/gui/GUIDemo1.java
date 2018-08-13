package gui;

import javax.swing.*;

//JFrame是GUI中的容器
//        JButton是最常见的组件- 按钮
public class GUIDemo1 {
    public static void main(String[] args) {
        //主窗体
        JFrame f=new JFrame("英雄联盟");
        //主窗体 设置大小
        f.setSize(400,300);
        //主窗体设置位置
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
    }
}
