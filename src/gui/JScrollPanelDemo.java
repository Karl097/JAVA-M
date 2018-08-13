package gui;

import javax.swing.*;

//使用带滚动条的面板有两种方式
//        1. 在创建JScrollPane，把组件作为参数传进去
//        JScrollPane sp = new JScrollPane(ta);
//        2. 希望带滚动条的面板显示其他组件的时候，调用setViewportView
//        sp.setViewportView(ta);
public class JScrollPanelDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("JScrollPanelDemo");
        f.setSize(400,300);
        f.setLocation(600,400);
        f.setLayout(null);

        //准备一个文本域，放很多数据
        JTextArea ta=new JTextArea();
        for (int i=0;i<1000;i++){
            ta.append(String.valueOf(i));
        }
        //设置自动换行
        ta.setLineWrap(true);

        JScrollPane sp=new JScrollPane(ta);
        f.setContentPane(sp);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
