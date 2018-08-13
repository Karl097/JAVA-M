package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//借助循环，和JDBC的知识，向数据库中插入100条数据，并在mysql-front中观察查询结果
public class JBDC1 {
    public static void main(String[] args) {
        int numbers=100;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection c=DriverManager.getConnection(  "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                                 "root", "admin");
        Statement s=c.createStatement();
        ){

            for (int i=0;i<numbers;i++){
                String str="insert into hero values(null,"+"'hero"+i+"'"+","+303.0f+","+150+")";
                s.execute(str);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
