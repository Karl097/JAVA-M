package gui;


import javax.swing.*;
import java.awt.*;

//创建一个水平JSplitPane，左边是pLeft,右边是pRight
public class JSplitPaneDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("JSplitPaneDemo");
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(null);

        JPanel pleft=new JPanel();
        //设置面板大小
        pleft.setBounds(0,0,300,40);
        //设置面板背景颜色
        pleft.setBackground(Color.red);
        //JPanel默认采用FlowLayout布局

        JButton b1=new JButton("Button1");
        JButton b2=new JButton("Button2");
        JButton b3=new JButton("Button3");

        //按钮加入到面板中
        pleft.add(b1);
        pleft.add(b2);
        pleft.add(b3);

        JPanel pright=new JPanel();
        pright.setBounds(0,50,300,40);
        pright.setBackground(Color.blue);

        JButton b4=new JButton("Button4");
        JButton b5=new JButton("Button5");
        JButton b6=new JButton("Button6");

        pright.add(b4);
        pright.add(b5);
        pright.add(b6);

        //创建一个水平SplitPanel，左边是pleft,右边是pright
        JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pleft,pright);
        //设置分割条位置
        sp.setDividerLocation(100);
        //设置sp为ContentPane
        f.setContentPane(sp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }
}
