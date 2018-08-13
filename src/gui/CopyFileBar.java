package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

//复制文件夹提供进度条，把文件复制的进度显示出来。
public class CopyFileBar {
    static long allFileSize = 0; // 所有需要复制的文件大小
    static long currentFileSizeCopied = 0;// 已复制的文件总大小

    //遍历获取文件的总大小
    public static void calculateAllFileSize(File file) {

        if (file.isFile()) {
            allFileSize += file.length();
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                calculateAllFileSize(f);
            }
        }
    }
    public static void main(String[] args) {
        JFrame f=new JFrame("CopyFile");
        f.setSize(400,120);
        f.setLocation(200,200);
        f.setLayout(new FlowLayout());

        JLabel l1=new JLabel("源文件地址：");
        JLabel l2=new JLabel("复制到：");
        JLabel l3=new JLabel("文件复制进度：");

        JTextField tf1=new JTextField();
        tf1.setPreferredSize(new Dimension(80,30));
        JTextField tf2=new JTextField();
        tf2.setPreferredSize(new Dimension(80,30));


        JButton b=new JButton("开始复制");
        JProgressBar pb=new JProgressBar();
        pb.setMaximum(100);
        pb.setStringPainted(true);

        f.add(l1);
        f.add(tf1);
        f.add(l2);
        f.add(tf2);
        f.add(b);
        f.add(l3);
        f.add(pb);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


        //点击开始复制进行文件复制
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //计算需要复制文件的总大小
                String Path=tf1.getText();
                File Folder=new File(Path);
                calculateAllFileSize(Folder);

                currentFileSizeCopied = 0;

                String srcPath = tf1.getText();
                String destPath = tf2.getText();

                //启动线程开始复制
                new Thread(){
                    public void run()
                    {
                        copyFolder(srcPath,destPath);
                    }
                }.start();
                //设置按钮不可用
                b.setEnabled(false);
            }
            //复制文件
            public void copyFile(String srcPath, String destPath){

                File srcFile = new File(srcPath);
                File destFile = new File(destPath);

                //缓存区，一次性读取1024字节
                byte[] buffer = new byte[1024];

                try (
                        FileInputStream fis = new FileInputStream(srcFile);
                        FileOutputStream fos = new FileOutputStream(destFile);
                ){
                    while(true){
                        //实际读取的长度是 actuallyReaded,有可能小于1024
                        int actuallyReaded = fis.read(buffer);
                        //-1表示没有可读的内容了
                        if(-1==actuallyReaded)
                            break;
                        fos.write(buffer, 0, actuallyReaded);
                        fos.flush();
                    }
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //复制文件夹
            public void copyFolder(String srcPath, String destPath) {
                File srcFolder = new File(srcPath);
                File destFolder = new File(destPath);

                if (!srcFolder.exists())
                    return;

                if (!srcFolder.isDirectory())
                    return;

                if (destFolder.isFile())
                    return;

                if (!destFolder.exists())
                    destFolder.mkdirs();

                File[] files = srcFolder.listFiles();
                for (File srcFile : files) {
                    if (!(srcFile.isDirectory())) {
                        File newDestFile = new File(destFolder, srcFile.getName());
                        copyFile(srcFile.getAbsolutePath(), newDestFile.getAbsolutePath());
                        currentFileSizeCopied += srcFile.length();

                        //计算复制进度
                        double current = (double) currentFileSizeCopied / (double) allFileSize;
                        int progress = (int) (current * 100);
                        pb.setValue(progress);
                        //复制完成，弹出提示
                        if (progress == 100) {
                            JOptionPane.showMessageDialog(f, "复制完成");
                            b.setEnabled(true);
                        }

                    }

                    if (srcFile.isDirectory()) {
                        File newDestFolder = new File(destFolder, srcFile.getName());
                        copyFolder(srcFile.getAbsolutePath(), newDestFolder.getAbsolutePath());
                    }
                }
            }
        });
    }
}
