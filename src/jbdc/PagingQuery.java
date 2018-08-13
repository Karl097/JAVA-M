package jbdc;

import java.sql.*;

//设计一个方法，进行分页查询
//public static void list(int start, int count)
//        start 表示开始页数，count表示一页显示的总数
//        list(0,5) 表示第一页，一共显示5条数据
//        list(10,5) 表示第三页，一共显示5条数据
public class PagingQuery {
    public static void list(int start, int count){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try (    Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin"); Statement s = c.createStatement();
        ){
            //查询语句
            String str="select * from hero limit " +start + "," + count;

            ResultSet rs=s.executeQuery(str);
            while (rs.next()){
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        list(0,5);
    }

}
