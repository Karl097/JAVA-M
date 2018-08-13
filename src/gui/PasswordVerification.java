package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//准备两个JTextFiled,一个用于输入账号，一个用于输入密码。
//        再准备一个JButton，上面的文字是登陆
//        点击按钮之后，首先进行为空判断，如果都不为空，则把账号和密码，拿到数据库中进行比较(SQL语句判断账号密码是否正确)，根据判断结果，使用JOptionPane进行提示。
public class PasswordVerification {
    public static void main(String[] args) {
        JFrame f=new JFrame("Login");
        f.setSize(400,300);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());

        //标签
        JLabel l1=new JLabel("账号:");
        l1.setBounds(0,0,50,30);
        JLabel l2=new JLabel("密码:");
        l2.setBounds(200,0,50,30);


        //文本框
        JTextField tf=new JTextField();
        tf.setPreferredSize(new Dimension(135,30));

        //密码框
        JPasswordField pf=new JPasswordField();
        pf.setPreferredSize(new Dimension(135,30));

        //检测按钮
        JButton b=new JButton("检测");
        b.setBounds(180,40,40,30);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().equals("")||String.valueOf(pf.getPassword()).length()==0)
                    JOptionPane.showMessageDialog(f,"请输入账号和密码！");
                else{
                    String account=tf.getText();
                    String password=String.valueOf(pf.getPassword());

                    if (verification(account,password))
                        JOptionPane.showMessageDialog(f,"登陆成功");
                    else
                        JOptionPane.showMessageDialog(f,"登陆失败");
                }

            }
        });

        f.add(l1);
        f.add(tf);
        f.add(l2);
        f.add(pf);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static boolean verification(String account,String password){
        boolean result=false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
                    Statement s = c.createStatement();

            //查询语句
            String str="select * from users where name='"+account+"' and password='"+password+"'";
            //执行并返回
            ResultSet rs=s.executeQuery(str);

            if (rs.next())
                result=true;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
