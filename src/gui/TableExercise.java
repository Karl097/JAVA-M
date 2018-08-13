package gui;


import jbdc.HeroDAO;
import set.Hero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableExercise {
    //把 htm和 table设计为静态，后面在更新表格数据的时候，就很容易访问这个两个对象
    //创建一个TableModel
    static HeroTableModel htm = new HeroTableModel();
    //根据htm创建一个Table
    static JTable t = new JTable(htm);

    static int start = 0;//开始页码
    static int count = 10;//每页显示数量

    //翻页按钮放在这里方便后面设置可用
    static JButton bHomePage = new JButton("首页");
    static JButton bPreviousPage = new JButton("上一页");
    static JButton bNextPage = new JButton("下一页");
    static JButton bLastPage = new JButton("末页");
    static JComboBox<Integer> pages = new JComboBox<>();

    private static boolean cbListenerEnabled = true;

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setSize(400, 350);
        f.setLocation(200, 200);
        f.setLayout(null);

        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(0, 0, 400, 200);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setBounds(0, 200, 400, 50);
        p2.setBounds(0, 250, 400, 50);
        //增加按钮
        //点击增加按钮，出现一个JDialog，在JDialog中进行增加
        JButton bAdd = new JButton("增加");
        p1.add(bAdd);

        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(f);
            }
        });

        //删除按钮
        //提供一个删除按钮，点击删除按钮之后，删除选中的行，并且刷新table中的数据，然后再默认选中第一行。
        //如果点击删除的时候，没有任何行被选中，则提示“删除前应该选中一行

        JButton bDelete = new JButton("删除");
        p1.add(bDelete);

        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(f);
            }
        });

        //编辑按钮
        //提供一个编辑按钮，点击的时候，弹出一个JDialog，显示选中的数据，并且能够修改。
        //如果点击的时候，没有选中任意一行，则提示 "编辑前请选中一行数据"
        JButton bEdit = new JButton("编辑");
        p1.add(bEdit);

        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit(f);
            }
        });

        //首页按钮监听
        bHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage();
            }
        });

        //上一页按钮监听
        bPreviousPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousPage();
            }
        });

        //下一页按钮监听
        bNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage();
            }
        });

        //末页按钮监听
        bLastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastPage();
            }
        });

        //设置按钮状态同时设置下拉框页数
        updateButtonStatus();
        //下拉框监听
        pages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                combobox();
            }
        });
        p2.add(bHomePage);
        p2.add(bPreviousPage);
        p2.add(pages);
        p2.add(bNextPage);
        p2.add(bLastPage);

        f.add(sp);
        f.add(p1);
        f.add(p2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


    //增加功能
    private static void add(JFrame f) {
        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        // 设置为模态
        d.setModal(true);

        d.setSize(300, 200);
        d.setLocation(220, 220);
        d.setLayout(null);

        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2, 2, 50, 50));
        input.setBounds(50, 20, 200, 100);

        JLabel lname = new JLabel("名称：");
        JTextField tfname = new JTextField();

        JLabel lhp = new JLabel("血量");
        JTextField tfhp = new JTextField();

        input.add(lname);
        input.add(tfname);
        input.add(lhp);
        input.add(tfhp);
        d.add(input);

        JPanel submit = new JPanel();
        submit.setBounds(0, 130, 300, 150);

        JButton db = new JButton("确定");
        submit.add(db);

        d.add(submit);

        db.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkEmpty(tfname, "名称")) {
                    if (checkNumber(tfhp, "血量")) {
                        HeroDAO dao = new HeroDAO();

                        Hero h = new Hero();

                        h.name = tfname.getText();
                        h.hp = Integer.parseInt(tfhp.getText());

                        //添加英雄
                        dao.add(h);

                        JOptionPane.showMessageDialog(d, "提交成功！");


                        updateTable();
                        d.setVisible(false);
                    }
                }
            }
        });
        d.setVisible(true);
    }

    //删除功能
    private static void delete(JFrame f) {
        //判断是否选中
        if (t.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(f, "请选中一行删除！");
            return;
        }

        if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f, "确定要删除？"))
            return;//不删除就返回

        //删除操作
        HeroDAO dao = new HeroDAO();
        int rowIndex = t.getSelectedRow();
        int id = (int) t.getValueAt(rowIndex, 0);
        dao.delete(id);
        updateTable();
    }

    //编辑功能
    private static void edit(JFrame f) {
        int index = t.getSelectedRow();
        //判断是否选中
        if (index == -1) {
            JOptionPane.showMessageDialog(f, "请选中一行编辑！");
            return;
        }
        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        // 设置为模态
        d.setModal(true);

        d.setSize(300, 200);
        d.setLocation(220, 220);
        d.setLayout(null);

        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2, 2, 50, 50));
        input.setBounds(50, 20, 200, 100);

        JLabel lname = new JLabel("名称：");
        JTextField tfname = new JTextField();

        JLabel lhp = new JLabel("血量");
        JTextField tfhp = new JTextField();

        input.add(lname);
        input.add(tfname);
        input.add(lhp);
        input.add(tfhp);
        d.add(input);

        JPanel submit = new JPanel();
        submit.setBounds(0, 130, 300, 150);

        JButton db = new JButton("确定");
        submit.add(db);

        d.add(submit);

        db.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkEmpty(tfname, "名称")) {
                    if (checkNumber(tfhp, "血量")) {
                        HeroDAO dao = new HeroDAO();

                        Hero h = htm.heroes.get(index);

                        h.name = tfname.getText();
                        h.hp = Integer.parseInt(tfhp.getText());

                        //添加英雄
                        dao.update(h);

                        JOptionPane.showMessageDialog(d, "提交成功！");


                        updateTable();
                        d.setVisible(false);
                    }
                }
            }
        });
        d.setVisible(true);
    }

    //首页功能
    private static void homePage() {
        start = 0;
        updateTable();
        updateButtonStatus();
    }

    //上一页功能
    private static void previousPage() {
        start -= count;
        updateTable();
        updateButtonStatus();
    }

    //下一页功能
    private static void nextPage() {
        start += count;
        updateTable();
        updateButtonStatus();
    }

    //末页功能
    private static void lastPage() {
        start = lastPagestart();
        updateTable();
        updateButtonStatus();
    }

    //设置按钮是否可用
    private static void updateButtonStatus() {
        int last = lastPagestart();
        //是否有上一页
        if (start != 0) {
            bHomePage.setEnabled(true);
            bPreviousPage.setEnabled(true);
        }
        //是否是第一页
        if (start == 0) {
            bHomePage.setEnabled(false);
            bPreviousPage.setEnabled(false);
        }
        //是否有下一页
        if (start < last) {
            bNextPage.setEnabled(true);
            bLastPage.setEnabled(true);
        }
        //是否是最后一页
        if (start == last) {
            bLastPage.setEnabled(false);
            bNextPage.setEnabled(false);
        }

        //设置下拉框页数
        int pageNumber = lastPagestart() / count + 1;
        cbListenerEnabled=false;
        pages.removeAllItems();
        for(
                int i = 0;
                i<pageNumber;i++)

        {
            pages.addItem(i + 1);
        }

        cbListenerEnabled=true;

        int currentPage = start / count + 1;
        pages.setSelectedItem(currentPage);

    }

    //设置最后一页开始的位置
    private static int lastPagestart() {
        int last;
        int total = new HeroDAO().getTotal();
        //刚好整除
        if (total % count == 0)
            last = total - count;
            //不能整除
        else
            last = total - total % count;

        return last;
    }

    //下拉框功能
    private static void combobox(){
        if(!cbListenerEnabled)
            return;

        int currentPage = (int) pages.getSelectedItem();
        start = (currentPage-1)*count;
        updateTable();
        updateButtonStatus();
    }

    //更新
    private static void updateTable(){
        htm.heroes = new HeroDAO().list(start,count);
        t.updateUI();
        if(!htm.heroes.isEmpty())
            t.getSelectionModel().setSelectionInterval(0, 0);
    }

    //为空判断
    private static boolean checkEmpty(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }


    //数字判断
    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,msg + " 只能是整数");
            tf.grabFocus();
            return false;
        }
        return true;
    }
}
