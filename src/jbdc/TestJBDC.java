package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//初始化驱动
public class TestJBDC {
    public static void main(String[] args) {
        Connection c=null;
        Statement s=null;
        try {
            //驱动类com.mysql.jdbc.Driver
            //就在 mysql-connector-java-5.0.8-bin.jar中
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");


            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin

            c = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                            "root", "admin");

            System.out.println("连接成功，获取连接对象： " + c);



            //创建Statement
            s=c.createStatement();
            System.out.println("获取Statement对象："+s);

            //s.execute执行sql语句
            //执行成功后，用mysql-front进行查看，明确插入成功
            // 准备sql语句
            // 注意： 字符串要用单引号'
            String sql="insert into hero values(null,"+"'hero3'"+","+303.0f+","+50+")";
            s.execute(sql);
            System.out.println("插入语句成功");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("没有找到文件");
    }catch (SQLException e){
            e.printStackTrace();
            System.out.println("连接失败");
        }finally {
//            数据库的连接是有限资源，相关操作结束后，养成关闭数据库的好习惯
//                    先关闭Statement
            if (s!=null){
                try {
                    s.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
//            后关闭Connection
            if (c!=null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //使用try-with-resource自动关闭连接
//        try (
//                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
//                        "root", "admin");
//                Statement s = c.createStatement();
//        )
//        {
//            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
//            s.execute(sql);
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
}
}
