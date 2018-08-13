package gui;

import javax.swing.*;

//只需要提供一句代码
//        javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
//        就可以把所有的组件切换成不同的风格。
//        注： 这句话需要加在最前面，如果已经创建了界面，再加这个有时候不能正常起作用。
public class JavaSkinDemo {
    public static void main(String[] args) {
        setLookAndFeel();

        JFrame f = new JFrame("java");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JButton b = new JButton("setLookAndFeel");
        b.setBounds(50, 50, 280, 30);

        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

    }
    private static void setLookAndFeel(){
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
