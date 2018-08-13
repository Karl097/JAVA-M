package gui;

import javax.swing.*;
import java.awt.*;

public class JToolBarDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("JToolBarDemo");
        f.setSize(600,500);
        f.setLocation(200,200);

        addMemu(f);

        JToolBar tb=new JToolBar();

        JButton b1=new JButton(new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\1.jpg"));
        JButton b2=new JButton(new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\2.jpg"));
        JButton b3=new JButton(new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\3.jpg"));
        JButton b4=new JButton(new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\4.jpg"));
        JButton b5=new JButton(new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\5.jpg"));
        JButton b6=new JButton(new ImageIcon("D:\\JAVA\\JAVA-M\\lib\\6.jpg"));

        tb.add(b1);
        tb.add(b2);
        tb.add(b3);
        tb.add(b4);
        tb.add(b5);
        tb.add(b6);

        //当鼠标放在按钮上的时候会出现提示
        b5.setToolTipText("河流之王");

        //禁止工具栏拖动
        tb.setFloatable(false);

        f.setLayout(new BorderLayout());
        f.add(tb,BorderLayout.NORTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
    public static void addMemu(JFrame f){
        JMenu VCS=new JMenu("VCS");
        //菜单栏
        JMenuBar mb=new JMenuBar();

        //菜单
        JMenu File=new JMenu("File");
        JMenu Edit=new JMenu("Edit");
        JMenu View=new JMenu("View");
        JMenu Navigate=new JMenu("Navigate");
        JMenu Code=new JMenu("Code");
        JMenu Analyze=new JMenu("Analyze");
        JMenu Refactor=new JMenu("Refactor");
        JMenu Build=new JMenu("Build");
        JMenu Run=new JMenu("Run");
        JMenu Tools=new JMenu("Tools");
        JMenu Window=new JMenu("Window");
        JMenu Help=new JMenu("Help");

        //菜单项
        File.add(new JMenuItem("New"));
        File.add(new JMenuItem("Open"));
        File.add(new JMenuItem("Open URL"));
        File.add(new JMenuItem("Open Project"));
        File.add(new JMenuItem("Close"));
        File.addSeparator();
        File.add(new JMenuItem("Settings"));


        //把菜单添加到菜单栏
        mb.add(File);
        mb.add(Edit);
        mb.add(View);
        mb.add(Navigate);
        mb.add(Code);
        mb.add(Analyze);
        mb.add(Refactor);
        mb.add(Build);
        mb.add(Run);
        mb.add(Tools);
        mb.add(VCS);
        mb.add(Window);
        mb.add(Help);

        //把JMenuBar添加到JFrame使用set而不是add
        f.setJMenuBar(mb);

    }
}
