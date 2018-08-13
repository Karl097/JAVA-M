package gui;
//通过table可以获取一个 TableSelectionModel，专门用于监听jtable选中项的变化
import set.Hero;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TableModelDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(new BorderLayout());

        //创建一个TableModel
        final HeroTableModel htm=new HeroTableModel();

        //根据htm创建一个Table
        JTable t=new JTable(htm);

        //准备一个JPanel上面放一个JLabel用于显示那条被选中
        JPanel p=new JPanel();
        final JLabel l=new JLabel("暂未选中条目");
        p.add(l);

        JScrollPane sp=new JScrollPane(t);

        //使用selection监听器监听哪条被选中
        t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //获取被选中的行
                int row=t.getSelectedRow();
                //获取相应的对象
                Hero h=htm.heroes.get(row);
                //更新标签内容
                l.setText("当前选中的英雄是："+h.name);
            }
        });

        f.add(p,BorderLayout.NORTH);
        f.add(sp,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
