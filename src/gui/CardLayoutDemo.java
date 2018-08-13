package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CardLayoutDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("CardLayoutDemo");

        //设置下拉框
        JPanel comboBoxPane=new JPanel();
        String buttonPanel="按钮面板";
        String inputPanel="输入框面板";

        String comboBoxItems[]={buttonPanel,inputPanel};
        JComboBox<String> cb=new JComboBox<>(comboBoxItems);
        comboBoxPane.add(cb);

        //设置两个卡片
        JPanel card1=new JPanel();
        card1.add(new JButton("JButton1"));
        card1.add(new JButton("JButton2"));
        card1.add(new JButton("JButton3"));

        JPanel card2=new JPanel();
        card2.add(new JTextField("输入框",20));

        JPanel cards=new JPanel(new CardLayout());
        cards.add(card1,buttonPanel);
        cards.add(card2,inputPanel);

        f.add(comboBoxPane,BorderLayout.NORTH);
        f.add(cards,BorderLayout.CENTER);

        f.setSize(400,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl=(CardLayout)(cards.getLayout());
                cl.show(cards,(String)e.getItem());
            }
        });
    }
}