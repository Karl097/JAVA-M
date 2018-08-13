package gui;

import javax.swing.*;
import java.awt.*;

//使用布局器做出计算器上的按钮效果
public class CalculatorButton {
    public static void main(String[] args) {
        JFrame f=new JFrame("Calculator");
        f.setSize(326,272);
        f.setLocation(200,200);

        f.setLayout(null);
        int gap=8;
        JPanel middlePanel = new JPanel();
        middlePanel.setBounds(gap, gap, 300, 225);
        f.add(middlePanel);
        middlePanel.setLayout(new GridLayout(4, 5,gap,gap));

        middlePanel.add(new JButton("7"));
        middlePanel.add(new JButton("8"));
        middlePanel.add(new JButton("9"));
        middlePanel.add(new JButton("/"));
        middlePanel.add(new JButton("sq"));
        middlePanel.add(new JButton("4"));
        middlePanel.add(new JButton("5"));
        middlePanel.add(new JButton("6"));
        middlePanel.add(new JButton("*"));
        middlePanel.add(new JButton("%"));
        middlePanel.add(new JButton("1"));
        middlePanel.add(new JButton("2"));
        middlePanel.add(new JButton("3"));
        middlePanel.add(new JButton("-"));
        middlePanel.add(new JButton("1/x"));
        middlePanel.add(new JButton("0"));
        middlePanel.add(new JButton("+/-"));
        middlePanel.add(new JButton("."));
        middlePanel.add(new JButton("+"));
        middlePanel.add(new JButton("="));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
