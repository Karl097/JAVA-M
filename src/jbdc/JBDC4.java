package jbdc;

import java.sql.*;

//获取总数
//        执行的sql语句为
//        select count(*) from hero
//        然后通过ResultSet获取出来
public class JBDC4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin"); Statement s = c.createStatement();) {

            String str="select count(*) from users";

            ResultSet rs=s.executeQuery(str);

            int total=0;
            while (rs.next()){
                total=rs.getInt(1);
            }
            System.out.printf("users表中总共有%d条数据",total);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
