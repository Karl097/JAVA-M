package gui;

import javax.swing.*;
import java.awt.*;

//JPanel即为基本面板
//        面板和JFrame一样都是容器，不过面板一般用来充当中间容器，把组件放在面板上，然后再把面板放在窗体上。
//        一旦移动一个面板，其上面的组件，就会全部统一跟着移动，采用这种方式，便于进行整体界面的设计
public class JPanelDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("JPanelDemo");
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

        //面板加入到窗体中
        f.add(p1);
        f.add(p2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
