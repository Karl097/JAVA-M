package jbdc;

import java.sql.*;

//没有事务的前提下
//假设业务操作是：加血，减血各做一次
//结束后，英雄的血量不变
//而减血的SQL
//不小心写错写成了 updata(而非update)
//那么最后结果是血量增加了，而非期望的不变
public class AffairDemo1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             //根据SQL语句创建PreparedStatement
             Statement s=c.createStatement()
        ){
            //加血SQL
            s.execute("update hero set hp=hp+1 where id=1");

            //减血SQL
            s.execute("updata hero set hp=hp+1 where id=1");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
