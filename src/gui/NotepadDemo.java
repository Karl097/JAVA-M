package gui;

import javax.swing.*;
import java.awt.*;

//创建一个记事本界面
public class NotepadDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame("无标题-记事本");
        f.setSize(800,600);
        f.setLocation(300,100);

        //菜单栏
        JMenuBar mb=new JMenuBar();

        //菜单
        JMenu File=new JMenu("文件(F)");
        JMenu Edit=new JMenu("编辑(E)");
        JMenu Format=new JMenu("格式(O)");
        JMenu Examine=new JMenu("查看(V)");
        JMenu Help=new JMenu("帮助(H)");

        //菜单项
        File.add(new JMenuItem("新建(N)                   Ctrl+N"));
        File.add(new JMenuItem("打开(O)                   Ctrl+O"));
        File.add(new JMenuItem("保存(S)                   Ctrl+S"));
        File.add(new JMenuItem("另存为(A)"));
        File.addSeparator();
        File.add(new JMenuItem("页面设置(U)"));
        File.add(new JMenuItem("打印(P)                   Ctrl+P"));
        File.addSeparator();
        File.add(new JMenuItem("退出(X)"));

        Edit.add(new JMenuItem("撤销(U)                   Ctrl+Z"));
        Edit.addSeparator();
        Edit.add(new JMenuItem("剪切(T)                   Ctrl+X"));
        Edit.add(new JMenuItem("复制(C)                   Ctrl+C"));
        Edit.add(new JMenuItem("粘贴(P)                   Ctrl+V"));
        Edit.add(new JMenuItem("删除(L)                   Del"));
        Edit.addSeparator();
        Edit.add(new JMenuItem("查找(F)                   Ctrl+F"));
        Edit.add(new JMenuItem("查找下一个(N)                F3"));
        Edit.add(new JMenuItem("替换(R)                   Ctrl+H"));
        Edit.add(new JMenuItem("转到(G)                   Ctrl+G"));
        Edit.addSeparator();
        Edit.add(new JMenuItem("全选(A)                   Ctrl+A"));
        Edit.add(new JMenuItem("时间/日期(D)                    F5"));

        Format.add(new JMenuItem("自动换行(W)"));
        Format.add(new JMenuItem("字体(F)"));

        Examine.add(new JMenuItem("状态栏(S)"));

        Help.add(new JMenuItem("查看帮助(H)"));
        Help.addSeparator();
        Help.add(new JMenuItem("关于记事本(A)"));

        mb.add(File);
        mb.add(Edit);
        mb.add(Format);
        mb.add(Examine);
        mb.add(Help);

        //文本域
        JTextArea ta=new JTextArea();
        ta.setLineWrap(true);
        JScrollPane sp=new JScrollPane(ta);

        //切记是set而不是add
        f.setJMenuBar(mb);
        f.setContentPane(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
