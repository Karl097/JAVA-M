package jbdc;

import java.sql.*;
import java.util.Scanner;

//当c.setAutoCommit(false);时，事务是不会提交的
//        只有执行使用 c.commit(); 才会提交进行
//
//        设计一个代码，删除表中前10条数据，但是删除前会在控制台弹出一个提示：
//        是否要删除数据(Y/N)
//        如果用户输入Y，则删除
//        如果输入N则不删除。
//        如果输入的既不是Y也不是N，则重复提示
public class AffairDemo3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             //根据SQL语句创建PreparedStatement
             Statement sDelete=c.createStatement();
             Statement sQuery=c.createStatement()
        ){
            //关闭自动提交
            c.setAutoCommit(false);

            //删除前十条数据
            ResultSet rs=sQuery.executeQuery("select id from hero order  by id asc limit 0,10");
            while (rs.next()){
                int id=rs.getInt(1);
                System.out.printf("试图删除id=%d的数据\n",id);
                sDelete.execute("delete from hero where id="+id);
            }

            //判断
            boolean b=true;
            do {
                System.out.println("是否要删除数据（Y/N）");
                Scanner sca=new Scanner(System.in);
                String str=sca.nextLine();
                if (str.equals("Y")) {
                    System.out.println("提交删除");
                    c.commit();
                    b=false;
                }
                if (str.equals("N")) {
                    System.out.println("放弃删除");
                    break;
                }
            }while (b);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
