package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//复利公式：
//        F = p* ( (1+r)^n );
//        F 最终收入
//        p 本金
//        r 年利率
//        n 存了多少年
public class WelfareCalculator {
    public static void main(String[] args) {
        JFrame f=new JFrame("WelfareCalculator");
        f.setSize(400,350);
        f.setLocation(200,200);
        f.setLayout(null);

        int gap=10;
        JPanel pInput=new JPanel();
        pInput.setLayout(new GridLayout(4,3,gap,gap));

        JLabel lfunds=new JLabel("起始资金:");
        JTextField tfunds=new JTextField();

        JLabel lincome=new JLabel("每年收益:");
        JTextField tincome=new JTextField();

        JLabel lyears=new JLabel("复利年数:");
        JTextField tyears=new JTextField();

        JLabel ladditionalfunds=new JLabel("每年追加资金：");
        JTextField tadditionalfunds=new JTextField();

        JLabel lyuan1=new JLabel("￥");
        JLabel lyuan2=new JLabel("￥");
        JLabel lyuan3=new JLabel("￥");
        JLabel lyuan4=new JLabel("￥");
        JLabel lyuan5=new JLabel("￥");

        JLabel lpercent=new JLabel("%");
        JLabel lyear=new JLabel("年");

        pInput.add(lfunds);
        pInput.add(tfunds);
        pInput.add(lyuan1);
        pInput.add(lincome);
        pInput.add(tincome);
        pInput.add(lpercent);
        pInput.add(lyears);
        pInput.add(tyears);
        pInput.add(lyear);
        pInput.add(ladditionalfunds);
        pInput.add(tadditionalfunds);
        pInput.add(lyuan2);

        pInput.setBounds(gap,gap,360,120);

        JButton b=new JButton("计算");
        b.setBounds(160,150,80,30);

        JPanel pOutput=new JPanel();
        pOutput.setLayout(new GridLayout(3,3,gap,gap));

        JLabel lprincipal=new JLabel("本金和：");
        JTextField tprincipal=new JTextField();

        JLabel linterest=new JLabel("利息和：");
        JTextField tinterest=new JTextField();

        JLabel lpr=new JLabel("本息和：");
        JTextField tpr=new JTextField();

        pOutput.add(lprincipal);
        pOutput.add(tprincipal);
        pOutput.add(lyuan3);
        pOutput.add(linterest);
        pOutput.add(tinterest);
        pOutput.add(lyuan4);
        pOutput.add(lpr);
        pOutput.add(tpr);
        pOutput.add(lyuan5);

        pOutput.setBounds(gap,210,360,90);

        f.add(pInput);
        f.add(b);
        f.add(pOutput);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            boolean checkedpass = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                check(tfunds,"起始资金");
                check(tincome,"每年收益");
                check(tyears,"复利年数");
                check(tadditionalfunds,"每年追加资金");

                if (checkedpass){
                    int init = Integer.parseInt(tfunds.getText());
                    int rate = Integer.parseInt(tincome.getText());
                    int year = Integer.parseInt(tyears.getText());
                    int invest = Integer.parseInt(tadditionalfunds.getText());

                    int baseSum = (year-1)*invest+init;
                    int totalSum=(int) (invest* fuli(  (1+(double)rate/100),(year-1)) + init* Math.pow((1+(double)rate/100) ,year));
                    int interestSum = totalSum -baseSum;

                    tprincipal.setText(String.format("%d",baseSum));
                    tinterest.setText(String.format("%d",interestSum));
                    tpr.setText(String.format("%d",totalSum));
                }
            }
            private int fuli(double rate, int year){
                int result = 0;
                for(int i=year;i>0;i--){
                    result+=Math.pow(rate,i);
                }
                return result;
            }
            private void check(JTextField tf, String msg) {
                if(!checkedpass)
                    return;
                String value = tf.getText();
                if(0==value.length()){
                    JOptionPane.showMessageDialog(f, msg + " 不能为空");
                    tf.grabFocus();
                    checkedpass = false;
                    return;
                }
                try {
                    Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(f, msg + " 必须是整数");
                    tf.grabFocus();
                    checkedpass = false;
                }
            }
        });
    }
}
