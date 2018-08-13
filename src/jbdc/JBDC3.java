package jbdc;

import java.sql.*;

//SQL语句判断账号密码是否正确
//1. 创建一个用户表，有字段name,password
//        2. 插入一条数据
//        insert into user values(null,'dashen','thisispassword');
//        3. SQL语句判断账号密码是否正确
//        判断账号密码的正确方式是根据账号和密码到表中去找数据，如果有数据，就表明密码正确了，如果没数据，就表明密码错误。
//        不恰当的方式 是把uers表的数据全部查到内存中，挨个进行比较。 如果users表里有100万条数据呢？ 内存都不够用的。
public class JBDC3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
             Statement s = c.createStatement();
        ) {
            String name="lishizhen";
            //正确密码是password
            String password="code";

            //查询语句
            String str="select * from users where name='"+name+"' and password='"+password+"'";
            //执行并返回
            ResultSet rs=s.executeQuery(str);

            if (rs.next())
                System.out.println("账号密码正确");
            else
                System.out.println("账号密码错误");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
