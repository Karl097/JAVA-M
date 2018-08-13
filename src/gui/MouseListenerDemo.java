package gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

//鼠标监听
//MouseListener 鼠标监听器
//        mouseReleased 鼠标释放
//        mousePressed 鼠标按下
//        mouseExited 鼠标退出
//        mouseEntered 鼠标进入
//        mouseClicked 鼠标点击
//        在本例中，使用mouseEntered，当鼠标进入图片的时候，图片就移动位置
public class MouseListenerDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("英雄联盟");
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(null);

        final JLabel l=new JLabel();
        ImageIcon i=new ImageIcon("C:\\Users\\李时珍\\Pictures\\Saved Pictures\\Saber.jpg");
        l.setIcon(i);
        l.setBounds(55,55,i.getIconWidth(),i.getIconHeight());

        f.add(l);

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Random r=new Random();
                int x=r.nextInt(f.getWidth()-l.getWidth());
                int y=r.nextInt(f.getHeight()-l.getHeight());

                l.setLocation(x,y);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
