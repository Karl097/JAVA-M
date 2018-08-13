package jbdc;

import set.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO {


    public HeroDAO() {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //返回链接
    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
    }

    //返回总数
    public static int getTotal(){
        int total=0;
        try (Connection c=getConnection(); Statement s=c.createStatement()){
            String sql="select count(*) from hero";
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                total=rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }


    @Override
    public void add(Hero hero) {
        String sql="insert into hero values (null ,?,?,?)";
        try (Connection c=getConnection();
             PreparedStatement ps=c.prepareStatement(sql);
        ){
            ps.setString(1, hero.name);
            ps.setFloat(2,hero.hp);
            ps.setInt(3,hero.damage);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql="delete from hero where id = ? ";
        try (Connection c = getConnection();
             PreparedStatement ps=c.prepareStatement(sql)
        ){
            ps.setInt(1,id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero hero) {
        String sql = "update hero set name = ? , hp =? , damage = ? where id = ?";
        try (Connection c = getConnection();
             PreparedStatement ps=c.prepareStatement(sql)
        ){
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.setInt(4, hero.id);

            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Hero get(int id) {
        Hero hero=null;
        try (Connection c = getConnection();
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

    @Override
    public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Hero> list(int start, int count) {
        List<Hero> list=new ArrayList<>();
        String sql="select * from hero limit ?,?";
        try (Connection c = getConnection();
             PreparedStatement ps=c.prepareStatement(sql);
        ){
            ps.setInt(1,start);
            ps.setInt(2,count);

            ResultSet rs=ps.executeQuery();

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
