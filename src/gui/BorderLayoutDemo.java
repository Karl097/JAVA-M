package gui;

import javax.swing.*;
import java.awt.*;

//设置布局器为BorderLayout
//        容器上的组件按照上北 下南 左西 右东 中的顺序摆放
public class BorderLayoutDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("方向");
        f.setSize(400,300);
        f.setLocation(200,200);

        f.setLayout(new BorderLayout());

        JButton b1=new JButton("上");
        JButton b2=new JButton("下");
        JButton b3=new JButton("左");
        JButton b4=new JButton("右");
        JButton b5=new JButton("中");

        f.add(b1,BorderLayout.NORTH);
        f.add(b2,BorderLayout.SOUTH);
        f.add(b3,BorderLayout.WEST);
        f.add(b4,BorderLayout.EAST);
        f.add(b5,BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
