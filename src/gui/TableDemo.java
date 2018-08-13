package gui;

import javax.swing.*;
import java.awt.*;

//显示一个Table需要两组数据
//        1. 一维数组： String[]columnNames 表示表格的标题
//        2. 二维数组： String[][] heros 表格中的内容
//        默认情况下，表格的标题是不会显示出来了，除非使用了JScrollPane
public class TableDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(new BorderLayout());

        String columnNames[]=new String[]{"id","name","hp","damage"};
        String heroes[][]=new String[][]{{"1","盖伦","616","300"},{"2","提莫","400","100"},{"3","剑圣","550","120"}};

        JTable t=new JTable(heroes,columnNames);
        //创建JScrollPane
        JScrollPane sp=new JScrollPane(t);
        //设置列宽
        t.getColumnModel().getColumn(0).setPreferredWidth(10);

        f.add(sp,BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
