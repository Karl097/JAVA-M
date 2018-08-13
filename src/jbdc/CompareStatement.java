package jbdc;

import java.sql.*;

//向数据库中插入10000条数据，分别使用Statement和PreparedStatement，比较各自花的时间差异
public class CompareStatement {
    public static void main(String[] args) {
        long start;
        long end;
        int total=10000;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql="insert into users values(null,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             //根据SQL语句创建PreparedStatement
             PreparedStatement ps=c.prepareStatement(sql);
             Statement s=c.createStatement();
        ){
            //使用Statement插入
            start=System.currentTimeMillis();
            for(int i=0;i<total;i++){
                s.execute("insert into users values (null ,'admin','password')");
            }
            end=System.currentTimeMillis();
            System.out.printf("使用Statement插入%d条语句，总共耗时%d毫秒\n",total,end-start);

            //使用PreparedStatement插入
            start=System.currentTimeMillis();
            for (int i=0;i<total;i++){
                ps.setString(1,"admin");
                ps.setString(2,"password");
                ps.execute();
            }
            end=System.currentTimeMillis();
            System.out.printf("使用PreparedStatement插入%d条语句，总共耗时%d毫秒\n",total,end-start);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
