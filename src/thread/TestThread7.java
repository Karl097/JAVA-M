package thread;
//1. 线程1 首先占有对象1，接着试图占有对象2
//        2. 线程2 首先占有对象2，接着试图占有对象1
//        3. 线程1 等待线程2释放对象2
//        4. 与此同时，线程2等待线程1释放对象1
public class TestThread7 {
    public static void main(String[] args) {
        final Hero ahri=new Hero();
        ahri.name="九尾妖狐";
        final Hero annie=new Hero();
        annie.name="安妮";

        Thread t1=new Thread(){
            public void run(){
                //占有九尾妖狐
                synchronized (ahri) {
                    System.out.println("t1已经占有九尾妖狐");

                    //暂停一秒，让另一个线程有时间占有安妮
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t1试图占有安妮");
                    System.out.println("t1等待中");
                    synchronized (annie){
                        System.out.println("do something");
                    }
                }
            }
        };
        t1.start();

        Thread t2=new Thread(){
            public void run(){
                //占有安妮
                synchronized (annie) {
                    System.out.println("t2已经占有九尾妖狐");

                    //暂停一秒，让另一个线程有时间占有九尾妖狐
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t2试图占有安妮");
                    System.out.println("t2等待中");
                    synchronized (ahri){
                        System.out.println("do something");
                    }
                }
            }
        };
        t2.start();
    }
}
