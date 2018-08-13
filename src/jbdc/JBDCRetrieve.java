package jbdc;

import java.sql.*;

//查询
public class JBDCRetrieve {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
             Statement s=c.createStatement();
        ){
            //查询语句
            String str="select * from hero";
            //查询结果赋给rs
            ResultSet rs=s.executeQuery(str);
            while (rs.next()){
                int i=rs.getInt("id");
                String name=rs.getString(2);
                float hp=rs.getFloat("hp");
                int damage=rs.getInt(4);
                System.out.printf("%d\t%s\t%.0f\t%d\t",i,name,hp,damage);
            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
