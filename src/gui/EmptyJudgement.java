package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//在JTextField中输入数据，在旁边加一个按钮JButton,当点击按钮的时候，判断JTextFiled中有没有数据，并使用JOptionPane进行提示
public class EmptyJudgement {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(400,300);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());

        //文本框
        JTextField tf=new JTextField();
        tf.setPreferredSize(new Dimension(180,30));

        //检测按钮
        JButton b=new JButton("检测");
        b.setSize(50,30);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().trim().equals(""))
                    //如果为空，弹出提示
                    JOptionPane.showMessageDialog(f,"文本内容为空！");
                    tf.grabFocus();
            }
        });

        f.add(tf);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
