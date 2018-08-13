package gui;
//首先说下TableModel的设计思想，在Model这种思想的指导下，数据和显示分离开来了。 比如对于JTable而言，有数据部分，也有显示部分(比如列宽等信息)。 数据部分，专门做一个类，叫做TableModel，就用于存放要显示的数据。
//
//        使用TableModel的方式存放Table需要显示的数据
//        HeroTableModel 继承AbstractTableModel ，进而实现了接口TableModel
//        在HeroTableModel 中提供一个table显示需要的所有信息
//        1. getRowCount 返回一共有多少行
//        2. getColumnCount 返回一共有多少列
//        3. getColumnName 每一列的名字
//        4. isCellEditable 单元格是否可以修改
//        5. getValueAt 每一个单元格里的值

import jbdc.HeroDAO;
import set.Hero;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class HeroTableModel extends AbstractTableModel {

    String columnNames[]=new String[]{"id","name","hp","damage"};
//    通过TableModel与DAO结合显示数据库中Hero信息。
//    DAO使用HeroDAO
//    在TableModel中，使用从DAO返回的List作为TableModel的数据
//
//    只需要修改HeroTableModel，无需修改TestGUI。 这正好演绎了Model设计思想中的数据分离的好处，当只需要数据发生变化的时候，修改Model即可，界面GUI部分，不需要做任何改动
    public List<Hero> heroes=new HeroDAO().list(0,10);


    //返回一共多少行
    @Override
    public int getRowCount() {
        return heroes.size();
    }

    //返回一共多少列
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    //返回单元格里的值
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hero h=heroes.get(rowIndex);
        if (0==columnIndex)
            return h.id;
        if (1==columnIndex)
            return h.name;
        if (2==columnIndex)
            return h.hp;
        if (3==columnIndex)
            return h.damage;
        return null;
    }

    //返回每一列的名称
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    //单元格是否可以修改
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
