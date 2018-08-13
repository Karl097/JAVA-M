package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql="insert into users values(null,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             //根据SQL语句创建PreparedStatement
             PreparedStatement ps=c.prepareStatement(sql);
             ){
            //逐个设置参数
            ps.setString(1,"admin");
            ps.setString(2,"code");
            //执行
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
