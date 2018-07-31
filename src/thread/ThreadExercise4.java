package thread;
//3个同步对象a, b, c
//        3个线程 t1,t2,t3
//        故意设计场景，使这3个线程彼此死锁
public class ThreadExercise4 {
    public static void main(String[] args) {
        Object a=new Object();
        Object b=new Object();
        Object c=new Object();

        Thread t1=new Thread(){
            public void run(){
                synchronized (a){
                    System.out.println("t1已经占有对象a");
                    //暂停一秒
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1试图占有b,c");
                    System.out.println("t1等待中");
                    synchronized (b){
                        synchronized (c){
                        }
                    }
                }
            }
        };
        t1.start();

        Thread t2=new Thread(){
            public void run(){
                synchronized (b){
                    System.out.println("t2已经占有对象b");
                    //暂停一秒
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2试图占有c,a");
                    System.out.println("t2等待中");
                    synchronized (c){
                        synchronized (a){
                        }
                    }
                }
            }
        };
        t2.start();


        Thread t3=new Thread(){
            public void run(){
                synchronized (c){
                    System.out.println("t3已经占有对象a");
                    //暂停一秒
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t3试图占有a,b");
                    System.out.println("t3等待中");
                    synchronized (a){
                        synchronized (b){
                        }
                    }
                }
            }
        };
        t3.start();
    }
}
