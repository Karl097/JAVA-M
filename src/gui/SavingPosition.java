package gui;
//在上次关闭的位置启动窗口
//比如这次使用这个窗口，导致窗口被移动到了右下角。 关闭这个窗口，下一次再启动的时候，就会自动出现在右下角。
//        思路提示：
//        启动一个线程，每个100毫秒读取当前的位置信息，保存在文件中，比如location.txt文件。
//        启动的时候，从这个文件中读取位置信息，如果是空的，就使用默认位置，如果不是空的，就把位置信息设置在窗口上。
//        读取位置信息的办法： f.getX() 读取横坐标信息，f.getY()读取纵坐标信息。
import javax.swing.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class SavingPosition implements Runnable {
    private JFrame f;

    File file=new File("e:/Test/location.txt");

    public SavingPosition(JFrame f){
        this.f=f;
    }

    public void run(){
        while (true){
            int x=f.getX();
            int y=f.getY();

            try (                FileOutputStream fos=new FileOutputStream(file);
                                 DataOutputStream dos=new DataOutputStream(fos);
            ){
                dos.writeInt(x);
                dos.writeInt(y);
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
