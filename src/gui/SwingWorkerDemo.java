package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//当SwingWorker执行execute的时候，调用默认有10根线程的线程池，执行doInBackground中的代码
public class SwingWorkerDemo {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(300,300);
        f.setLocation(200,200);
        f.setLayout(new FlowLayout());

        JButton b1=new JButton("在事件调度线程执行长耗时任务");
        JButton b2=new JButton("使用SwingWorker执行长耗时任务");
        JLabel l=new JLabel("任务执行结果");

        f.add(b1);
        f.add(b2);
        f.add(l);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("开始执行");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                l.setText("执行完毕");
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void,Void> worker=new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        System.out.println("执行这个任务的线程是："+Thread.currentThread().getName());
                        l.setText("开始执行");
                        try {
                            Thread.sleep(5000);
                        }catch (InterruptedException e2){
                            e2.printStackTrace();
                        }
                        l.setText("执行完毕");
                        return null;
                    }
                };
                worker.execute();
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
