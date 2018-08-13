package jbdc;
//DAO=DataAccess Object
//        数据库访问对象

import set.Hero;

import java.util.List;

public interface DAO {
    //增加
    public void add(Hero hero);
    //删除
    public void delete(int id);
    //修改
    public void update(Hero hero);
    //获取
    public Hero get(int id);
    //查询
    public List<Hero> list();
    //分页查询
    public List<Hero> list(int start,int count);
}
