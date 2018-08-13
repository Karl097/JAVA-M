package gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//键盘监听
//键盘监听器： KeyListener
//        keyPressed 代表 键被按下
//        keyReleased 代表 键被弹起
//        keyTyped 代表 一个按下弹起的组合动作
//        KeyEvent.getKeyCode() 可以获取当前点下了哪个键
public class KeyListenerDemo {
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
                    //39代表按下了右键
                if (e.getKeyCode()==39){
                    //图片向右移动
                    l.setLocation(l.getX()+10,l.getY());
                }
            }
        });

        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
