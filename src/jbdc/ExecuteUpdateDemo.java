package jbdc;

import java.sql.*;

//execute 和 executeUpdate
public class ExecuteUpdateDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             Statement s=c.createStatement();)
        {
            //execute可以执行查询语句
            String sql="select * from hero";
            s.execute(sql);
            ResultSet rs=s.getResultSet();
            //executeUpdate不可执行查询语句

            // execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
            boolean isSelect=s.execute(sql);
            System.out.println(isSelect);

            // executeUpdate返回的是int，表示有多少条数据受到了影响
            String Updatesql="update hero set hp =300 where id<=100";
            int numbers=s.executeUpdate(Updatesql);
            System.out.println(numbers);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
