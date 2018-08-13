package gui;
//以新增数据到数据库中，然后更新Table为例
//如果用户输入的名称为空，或者血量不是小数，在提交数据的时候都会报错。
//        “感觉上” 界面就卡住了。 这是不友好的人机交互行为。
//        所以需要加上输入项的验证，如果输入的数据不合格，应该弹出对话框提示用户具体原因。
import jbdc.HeroDAO;
import set.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableModelDemo1 {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(new BorderLayout());

        //创建一个TableModel
        final HeroTableModel htm=new HeroTableModel();

        //根据htm创建一个Table
        final JTable t=new JTable(htm);
        // 设置选择模式为 只能选中一行
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        t.getSelectionModel().setSelectionInterval(0,0);
        JScrollPane sp=new JScrollPane(t);

        //准备一个JPanel上面放按钮和文本框
        JPanel p=new JPanel();
        final JLabel lname=new JLabel("名称：");
        final JTextField tfname=new JTextField();
        tfname.setPreferredSize(new Dimension(80,30));
        final JLabel lhp=new JLabel("血量：");
        final JTextField tfhp=new JTextField();
        tfhp.setPreferredSize(new Dimension(80,30));
        JButton b=new JButton("增加");

        p.add(lname);
        p.add(tfname);
        p.add(lhp);
        p.add(tfhp);
        p.add(b);

        //为按钮增加监听
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HeroDAO dao=new HeroDAO();

                Hero h=new Hero();
                //为空判断
                if (tfname.getText().length()==0){
                    JOptionPane.showMessageDialog(f,"请输入名称！");
                    tfname.grabFocus();
                    return;
                }
                //小数判断
                try {
                    Float.parseFloat(tfhp.getText().trim());
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(f,"血量只能是数字！");
                    tfhp.grabFocus();
                    return;
                }


                h.name=tfname.getText();
                h.hp=Integer.parseInt(tfhp.getText());

                //添加英雄
                dao.add(h);

                //更新tablemodel中的数据
                htm.heroes=dao.list();

                // 调用JTable的updateUI，刷新界面。
                // 刷新界面的时候，会到tablemodel中去取最新的数据
                // 就能看到新加进去的数据了
                t.updateUI();


                t.getSelectionModel().setSelectionInterval(0,0);
            }
        });

        f.add(p,BorderLayout.NORTH);
        f.add(sp,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
