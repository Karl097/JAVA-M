package jbdc;

import set.Hero;
 import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ORMDemo {
    public static void main(String[] args) {
        List<Hero> hs=list();
        System.out.println("数据库中总共有"+hs.size()+"条数据");
        System.out.println("新加了一条数据");
        Hero h=new Hero();
        h.name="Thanos";
        add(h);
        hs=list();
        System.out.println("数据库中总共有"+hs.size()+"条数据");
        System.out.println("取出id=12的数据，它的name是:");
        h=get(12);
        System.out.println(h.name);
        System.out.println("把英雄name改为101，并更新到数据库");
        h.name="101";
        update(h);
        System.out.println("取出id=12的数据，它的name是:");
        h=get(12);
        System.out.println(h.name);
        System.out.println("删除id=12的数据");
        delete(h);
        System.out.println("数据库中总共有"+hs.size()+"条数据");
    }
    //提供方法get(int id)
//        返回一个Hero对象
    public static Hero get(int id){
        Hero hero=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             Statement s=c.createStatement();
        ){
            String sql="select * from hero where id="+id;
            ResultSet rs=s.executeQuery(sql);
            if (rs.next()){
                hero=new Hero();
                hero.id=rs.getInt(1);
                hero.name=rs.getString(2);
                hero.hp=rs.getFloat(3);
                hero.damage=rs.getInt(4);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return hero;
    }

//    把一个Hero对象插入到数据库中
//    public static void add(Hero h)
    public static void add(Hero h){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql="insert into hero values (null ,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             PreparedStatement ps=c.prepareStatement(sql);
        ){
            ps.setString(1,"Thanos");
            ps.setFloat(2,424);
            ps.setInt(3,133);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
//    把这个Hero对象对应的数据删除掉
//    public static void delete(Hero h)
    public static void delete(Hero h){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql="delete from hero where id = ? ";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
          PreparedStatement ps=c.prepareStatement(sql)
        ){
            ps.setInt(1,h.id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    更新这条Hero对象
//    public static void update(Hero h)
    public static void update(Hero h){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "update hero set name = ? , hp =? , damage = ? where id = ?";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             PreparedStatement ps=c.prepareStatement(sql)
        ){
            ps.setString(1, h.name);
            ps.setFloat(2, h.hp);
            ps.setInt(3, h.damage);
            ps.setInt(4, h.id);

            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
//    把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
//    public static List<Hero> list();
    public static List<Hero> list(){
        List<Hero> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
             Statement s=c.createStatement()
        ){
            ResultSet rs=s.executeQuery("select * from hero");
            while (rs.next()){
                Hero hero=new Hero();
                hero.id=rs.getInt(1);
                hero.name=rs.getString(2);
                hero.hp=rs.getFloat(3);
                hero.damage=rs.getInt(4);
                list.add(hero);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}

