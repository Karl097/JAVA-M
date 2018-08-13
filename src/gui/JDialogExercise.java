package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//首先设计一个JFrame,上面有一个按钮，文字是 "打开一个模态窗口"。
//        点击该按钮后，随即打开一个模态窗口。
//        在这个模态窗口中有一个按钮，文本是 "锁定大小", 点击后，这个模态窗口的大小就被锁定住，不能改变。 再次点击，就回复能够改变大小
public class JDialogExercise {
    public static void main(String[] args) {
        JFrame f=new JFrame("外部窗体");
        f.setSize(800,600);
        f.setLocation(100,100);
        f.setLayout(null);


        JButton b1=new JButton("打开一个模态窗口");
        b1.setBounds(50,50,280,30);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //根据外部窗体实例化JDialog
                JDialog d=new JDialog(f);
                //设置为模态
                d.setModal(true);

                d.setTitle("模态的对话框");
                d.setSize(400,300);
                d.setLocation(200,200);
                d.setLayout(null);

                JButton b2=new JButton("锁定大小");
                b2.setBounds(50,50,120,120);

                b2.addActionListener(new ActionListener() {
                    boolean lock=false;
                    public void actionPerformed(ActionEvent e) {
                        d.setResizable(lock);
                        lock=!lock;
                        b2.setText(lock?"解锁大小":"锁定大小");
                    }
                });
                d.add(b2);
                d.setVisible(true);
            }
        });

        f.add(b1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
