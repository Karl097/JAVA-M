package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSplitPaneExercise {
    public static void main(String[] args) {
        JFrame f=new JFrame("LOL");
        f.setSize(400,300);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        //设置按钮面板
        JPanel pleft=new JPanel();
        pleft.setBounds(50, 50, 300, 60);
        pleft.setBackground(Color.LIGHT_GRAY);

        //三个按钮
        JButton b1=new JButton("盖伦");
        pleft.add(b1);
        JButton b2=new JButton("提莫");
        pleft.add(b2);
        JButton b3=new JButton("安妮");
        pleft.add(b3);


        JPanel pright=new JPanel();
//        ImageIcon i1=new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\gareen.jpg");
//        ImageIcon i2=new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\teemo.jpg");
//        ImageIcon i3=new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\annie.jpg");
//        JLabel l1=new JLabel();
//        l1.setIcon(i1);
//        l1.setBounds(20,20, i1.getIconWidth(), i1.getIconHeight());
//        pright.add(l1);
//        l1.setVisible(false);
//
//        JLabel l2=new JLabel();
//        l2.setIcon(i2);
//        l2.setBounds(20,20, i2.getIconWidth(), i2.getIconHeight());
//        pright.add(l2);
//        l2.setVisible(false);
//
//        JLabel l3=new JLabel();
//        l3.setIcon(i3);
//        l3.setBounds(20,20, i3.getIconWidth(), i3.getIconHeight());
//        pright.add(l3);
//        l3.setVisible(false);
//
//        b1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                l1.setVisible(true);
//                l2.setVisible(false);
//                l3.setVisible(false);
//            }
//        });
//        b2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                l1.setVisible(false);
//                l2.setVisible(true);
//                l3.setVisible(false);
//            }
//        });
//        b3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                l1.setVisible(false);
//                l2.setVisible(false);
//                l3.setVisible(true);
//            }
//        });

        //设置标签
        JLabel lPic = new JLabel("");

        ImageIcon i = new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\gareen.jpg");
        lPic.setIcon(i);

        pright.add(lPic);

        pright.setBackground(Color.lightGray);
        pright.setBounds(10, 150, 300, 60);


        JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pleft,pright);
        sp.setDividerLocation(100);

        f.setContentPane(sp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        switchPic(b1,"gareen",lPic);
        switchPic(b2,"teemo",lPic);
        switchPic(b3,"annie",lPic);
    }
    private static void switchPic(JButton b, String fileName, JLabel lPic) {
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\"+fileName+".jpg");
                lPic.setIcon(i);
            }
        });

    }
}
