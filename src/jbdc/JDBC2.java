package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//设计一个方法
//public static void execute(String sql)
//        方法接受的参数是SQL语句，无论是增加，删除，还是修改，都调用这个方法，每次传不同的SQL语句作为参数
public class JDBC2 {
    public static void main(String[] args) {

        //增加数据
        execute("insert into hero values(1,'teemo',334,32)");
        //修改数据
        execute("update hero set hp=222 where id=1");
        //删除数据
        execute("delete from hero where id=1");
    }
    public static void execute(String sql){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
             Statement s=c.createStatement();
        ){
            s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
