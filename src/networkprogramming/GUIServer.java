package networkprogramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GUIServer {
    public static void main(String[] args) throws Exception{
        JFrame f=new JFrame("Server");
        f.setSize(400,300);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        JPanel pUp=new JPanel();
        JTextArea ta=new JTextArea();
        ta.setPreferredSize(new Dimension(380,200));
        ta.setLineWrap(true);

        pUp.add(ta);

        JPanel pDown=new JPanel();
        pDown.setLayout(new FlowLayout());
        JTextField tf=new JTextField();
        tf.setPreferredSize(new Dimension(200,30));
        JButton b=new JButton("Send");

        pDown.add(tf);
        pDown.add(b);

        JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,pUp,pDown);

        sp.setDividerLocation(200);

        f.setContentPane(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        ServerSocket ss=new ServerSocket(8888);
        final Socket s =  ss.accept();
        new Thread(){
            public void run() {
                while (true) {
                    try {
                        DataInputStream dis = new DataInputStream(
                                s.getInputStream());
                        String text = dis.readUTF();
                        ta.append(text + "\r\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                ta.append(text+"\r\n");

                try {
                    DataOutputStream dos = new DataOutputStream(
                            s.getOutputStream());
                    dos.writeUTF(text);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
