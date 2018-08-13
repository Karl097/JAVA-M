package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//参考 练习-查找文件内容中的做法，使用swing来完成这个功能。
//        查找文件内容本身是一个比较耗时的任务，采用长耗时任务线程的手段，开发这个功能
public class SearchBySwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new frame().setVisible(true));
    }
    static class frame extends JFrame {
        JLabel lDirectory=new JLabel("目录");
        JTextField tfDirectory=new JTextField();

        JLabel lContent=new JLabel("内容");
        JTextField tfContent=new JTextField();

        JButton b=new JButton("开始查找");

        private void freeze(){
            b.setText("正在查找");
            b.setEnabled(false);
            tfDirectory.setEnabled(false);
            tfContent.setEnabled(false);
        }

        private void unfreeze(){
            b.setText("开始查找");
            b.setEnabled(true);
            tfDirectory.setEnabled(true);
            tfContent.setEnabled(true);
        }

        public frame(){
            setTitle("Search");
            setSize(300, 200);
            setLocation(200, 200);
            setLayout(new FlowLayout());

            tfDirectory.setPreferredSize(new Dimension(250,30));

            tfContent.setPreferredSize(new Dimension(250,30));


            add(lDirectory);
            add(tfDirectory);
            add(lContent);
            add(tfContent);
            add(b);

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String path=tfDirectory.getText();
                    String code=tfContent.getText();
                    if(0==path.length()){
                        JOptionPane.showMessageDialog(frame.this, "搜索目录不能为空");
                        tfDirectory.grabFocus();
                        return;
                    }
                    if(0==code.length()){
                        JOptionPane.showMessageDialog(frame.this, "搜索内容不能为空");
                        tfContent.grabFocus();
                        return;
                    }

                    File folder=new File(path);
                    if(!folder.exists()){
                        JOptionPane.showMessageDialog(frame.this, "搜索目录不存在");
                        tfDirectory.grabFocus();
                        return;
                    }
                    if(!folder.isDirectory()){
                        JOptionPane.showMessageDialog(frame.this, "搜索目录不是一个文件夹");
                        tfDirectory.grabFocus();
                        return;
                    }

                    //设置按钮不可用
                    freeze();
                    SwingWorker<Void,Void> worker=new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {


                            search(folder,code);
                            JOptionPane.showMessageDialog(frame.this,"总共找到满足条件的文件："+count);
                            //设置按钮可用
                            unfreeze();
                            return null;
                        }
                    };
                    worker.execute();
                }
            });

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    private static int count=0;

    public static void search(File file, String search) {
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
                String fileContent = readFileConent(file);
                if(fileContent.contains(search)){
                    count++;
                }
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }

    public static String readFileConent(File file){
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
