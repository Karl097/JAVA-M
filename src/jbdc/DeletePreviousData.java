package jbdc;

import java.sql.*;

//当插入一条数据之后，通过获取自增长id，得到这条数据的id，比如说是55.
//        删除这条数据的前一条，54.
//        如果54不存在，则删除53，以此类推直到删除上一条数据。
public class DeletePreviousData {
    public static void main(String[] args) {
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
            ps.setString(1,"admin");
            ps.setString(2,"code");
            //执行
            ps.execute();

            //通过getGeneratedKeys获取id
            ResultSet rs=ps.getGeneratedKeys();
            int id=-1;
            if (rs.next()){
                id=rs.getInt(1);
            }
            System.out.println("刚刚插入的数据id是"+id);

            for (int i=id-1;i>0;i--){
                int Targetid=i;
                ResultSet rs2=s.executeQuery("select  id from users where id ="+Targetid);
                if (rs2.next()){
                    System.out.println("id="+Targetid+"存在，删除该数据");
                    s.execute("delete from users where id ="+Targetid);
                    break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
