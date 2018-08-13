package gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//把键盘监听中的代码完善，使得由当前的只能向右移动，完善为上下左右移动都可以。
//        提示：keyCode与方向的对应关系
//        38 上
//        40 下
//        37 左
//        39 右
public class KeyListenerExercise {
    public static void main(String[] args) {
        JFrame f=new JFrame("英雄联盟");
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(null);

        final JLabel l=new JLabel();
        ImageIcon i=new ImageIcon("C:\\Users\\李时珍\\Pictures\\Saved Pictures\\Saber.jpg");
        l.setIcon(i);
        l.setBounds(55,55,i.getIconWidth(),i.getIconHeight());

        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //向左移动
                if (e.getKeyCode()==37)
                    l.setLocation(l.getX()-10,l.getY());
                //向上移动
                if (e.getKeyCode()==38)
                    l.setLocation(l.getX(),l.getY()-10);
                //向右移动
                if (e.getKeyCode()==39)
                    l.setLocation(l.getX()+10,l.getY());
                //向下移动
                if (e.getKeyCode()==40)
                    l.setLocation(l.getX(),l.getY()+10);
            }
        });

        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
