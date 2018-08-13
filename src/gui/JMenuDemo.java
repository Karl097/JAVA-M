package gui;

import javax.swing.*;

//菜单栏和菜单、菜单项
public class JMenuDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("IntelliJ IDEA");
        f.setSize(800,600);
        f.setLocation(200,200);

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
        JMenu VCS=new JMenu("VCS");
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

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
