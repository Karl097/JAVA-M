package gui;

import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("SwingDemo");
        f.setSize(400,300);
        f.setLocation(400,400);
        f.setLayout(null);

        //标签JLabel显示文字
        JLabel l1=new JLabel("这是Saber吗");
        //设置标签的颜色
        l1.setForeground(Color.red);
        l1.setBounds(0,0,150,30);


        //标签JLabel显示图片
        JLabel l2=new JLabel();
        //根据图片创建ImageIcon对象
        ImageIcon i=new ImageIcon("C:\\Users\\李时珍\\Pictures\\Saved Pictures\\Saber.jpg");
        l2.setIcon(i);
        //标签的大小设置为ImageIcon
        l2.setBounds(0,30,i.getIconWidth(),i.getIconHeight());


        //复选框JCheckBox
        JCheckBox bCheckBox1=new JCheckBox("是");
        //默认被选中
        bCheckBox1.setSelected(true);
        bCheckBox1.setBounds(0,150,50,30);
        JCheckBox bCheckBox2=new JCheckBox("不是");
        bCheckBox2.setBounds(0,180,60,30);
        //判断是否被选中
        System.out.println(bCheckBox2.isSelected());

        //JRadioButton 单选框,为了实现只能选中一个，还需要用到ButtonGroup
        JRadioButton bRadioButton1=new JRadioButton("Saber释放大招");
        bRadioButton1.setSelected(true);
        bRadioButton1.setBounds(0,210,130,30);
        JRadioButton bRadioButton2=new JRadioButton("Saber不释放大招");
        bRadioButton2.setBounds(0,240,140,30);
        //判断是否被选中
        System.out.println(bRadioButton1.isSelected());

//        JComboBox 下拉框
//        使用getSelectedItem来获取被选中项
//        使用setSelectedItem() 来指定要选中项
        String skills[]=new String[]{"誓约胜利之剑","Smash"};
        JComboBox jcb=new JComboBox(skills);
        jcb.setBounds(160,0,140,30);

        //按钮分组
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(bRadioButton1);
        bg1.add(bRadioButton2);
        ButtonGroup bg2=new ButtonGroup();
        bg2.add(bCheckBox1);
        bg2.add(bCheckBox2);

        f.add(l1);
        f.add(l2);
        f.add(bCheckBox1);
        f.add(bCheckBox2);
        f.add(bRadioButton1);
        f.add(bRadioButton2);
        f.add(jcb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        int option=JOptionPane.showConfirmDialog(f,"Saber的大招是誓约胜利之剑吗？");
        if (JOptionPane.OK_OPTION==option){
            String answer=JOptionPane.showInputDialog(f,"如果是，请输入yes");
            if ("yes".equals(answer))
                JOptionPane.showMessageDialog(f,"恭喜你答对了");
        }
    }
}
