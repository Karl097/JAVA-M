package jbdc;
//数据库连接池
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    List<Connection> cs=new ArrayList<>();

    //链接数量
    int size;

    public ConnectionPool(int size){
        this.size=size;
        init();
    }

    public  void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i=0;i<size;i++) {
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
                cs.add(c);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //获取链接
    public synchronized Connection getConnection(){
        while (cs.isEmpty()){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Connection c=cs.remove(0);
        return c;
    }
    //返还链接
    public synchronized void returnConnection(Connection c){
        cs.add(c);
        this.notifyAll();
    }
}
