package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

//synchronized表示当前线程，独占 对象 someObject
//        当前线程独占 了对象someObject，如果有其他线程试图占有对象someObject，就会等待，直到当前线程释放对someObject的占用。
//        someObject 又叫同步对象，所有的对象，都可以作为同步对象
//        为了达到同步的效果，必须使用同一个同步对象
//
//        释放同步对象的方式： synchronized 块自然结束，或者有异常抛出
public class TestThread6 {
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    public static void main(String[] args) {
        final Object someObject=new Object();

        Thread t1=new Thread(){
            public void run() {
                try {
                    System.out.println(now() + "t1线程开始运行");
                    System.out.println(now() + this.getName() + "试图占有对象:someObject");
                    synchronized (someObject) {
                        System.out.println(now() + this.getName() + "占有对象:someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + "释放对象:someObject");
                    }
                    System.out.println(now()+"t1线程已经结束");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t1.setName("t1");
        t1.start();


        Thread t2=new Thread(){
            public void run() {
                try {
                    System.out.println(now() + "t2线程开始运行");
                    System.out.println(now() + this.getName() + "试图占有对象:someObject");
                    synchronized (someObject) {
                        System.out.println(now() + this.getName() + "占有对象:someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + "释放对象:someObject");
                    }
                    System.out.println(now()+"t2线程已经结束");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t2.setName("t2");
        t2.start();
    }
}
