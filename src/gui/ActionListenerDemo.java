package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//按钮监听
//创建一个匿名类实现ActionListener接口，当按钮被点击时，actionPerformed方法就会被调用
public class ActionListenerDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("英雄联盟");
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(null);

        final JLabel l=new JLabel();
        ImageIcon i=new ImageIcon("C:\\Users\\李时珍\\Pictures\\Saved Pictures\\Saber.jpg");
        l.setIcon(i);
        l.setBounds(55,55,i.getIconWidth(),i.getIconHeight());

        JButton b=new JButton("隐藏图片");
        b.setBounds(150,200,100,30);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);
            }
        });

        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
