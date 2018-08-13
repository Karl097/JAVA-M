package gui;

import javax.swing.*;
import java.awt.*;

//设计一个线程，每隔100毫秒，就把进度条的进度+1。
//        从0%一直加到100%
//        刚开始加的比较快，以每隔100毫秒的速度增加，随着进度的增加，越加越慢
//        变得多慢，根据你们和处女座同学，朋友的相处体验，自己把控
public class ProgressBar {
    public static void main(String[] args) {
        JFrame f=new JFrame("ProgressBar");
        f.setSize(400,300);
        f.setLocation(200,200);
        f.setLayout(new FlowLayout());

        JProgressBar pb=new JProgressBar();

        //进度条最大为100
        pb.setMaximum(100);
        Thread t=new Thread(){
          public void run(){
              int sleep=100;
             for (int i=0;i<100;i++){
                 pb.setValue(i+1);
                 try {
                     Thread.sleep(sleep+i*20);
                 }catch (InterruptedException e){
                     e.printStackTrace();
                 }
             }
          }
        };
        t.start();
        pb.setStringPainted(true);

        f.add(pb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
