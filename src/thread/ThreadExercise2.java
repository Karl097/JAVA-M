package thread;

import javax.swing.plaf.FontUIResource;
import java.io.FileOutputStream;

//英雄有可以放一个技能叫做: 波动拳-a du gen。
//        每隔一秒钟，可以发一次，但是只能连续发3次。
//
//        发完3次之后，需要充能5秒钟，充满，再继续发。
public class ThreadExercise2 {
    public static void main(String[] args) {
        while (true){
            for (int i=0;i<3;i++){
                System.out.printf("波动拳第%d发\n",i+1);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException  e){
                    e.printStackTrace();
                }
            }

            System.out.println("开始为时5秒的充能");
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
