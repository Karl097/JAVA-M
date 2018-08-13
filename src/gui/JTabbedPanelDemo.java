package gui;


import javax.swing.*;
import java.awt.*;

public class JTabbedPanelDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("JTabbedPanelDemo");
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(null);

        JPanel p1=new JPanel();
        //设置面板大小
        p1.setBounds(0,0,300,40);
        //设置面板背景颜色
        p1.setBackground(Color.red);
        //JPanel默认采用FlowLayout布局

        JButton b1=new JButton("Button1");
        JButton b2=new JButton("Button2");
        JButton b3=new JButton("Button3");

        //按钮加入到面板中
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);

        JPanel p2=new JPanel();
        p2.setBounds(0,50,300,40);
        p2.setBackground(Color.blue);

        JButton b4=new JButton("Button4");
        JButton b5=new JButton("Button5");
        JButton b6=new JButton("Button6");

        p2.add(b4);
        p2.add(b5);
        p2.add(b6);

        JTabbedPane tp=new JTabbedPane();
        tp.add(p1);
        tp.add(p2);

        //设置tab的标题
        tp.setTitleAt(0,"redTab");
        tp.setTitleAt(1,"blueTab");

        ImageIcon i=new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\j.png");
        tp.setIconAt(0,i);
        tp.setIconAt(1,i);

        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
