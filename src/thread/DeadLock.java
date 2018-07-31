package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//当多个线程按照不同顺序占用多个同步对象的时候，就有可能产生死锁现象。
//        死锁之所以会发生，就是因为synchronized 如果占用不到同步对象，就会苦苦的一直等待下去，借助tryLock的有限等待时间，解决死锁问题
public class DeadLock {
    public static void main(String[] args) throws InterruptedException{
        final Hero ahri = new Hero();
        ahri.name = "九尾妖狐";
        final Hero annie = new Hero();
        annie.name = "安妮";

        Lock ahrilock=new ReentrantLock();//九尾妖狐锁
        Lock annielock=new ReentrantLock();//安妮锁

        Thread t1 = new Thread(){
            public void run(){
                boolean ahrilocked=false;
                boolean annielocked=false;

                try {
                    //试图十秒之内占有
                    ahrilocked=ahrilock.tryLock(10,TimeUnit.SECONDS);
                    if (ahrilocked){
                        System.out.println("t1 已占有九尾妖狐");
                    //暂停1秒，给t2执行时间
                        Thread.sleep(1000);
                        System.out.println("t1 试图在十秒之内占有安妮");

                        try {
                            annielocked=annielock.tryLock(10,TimeUnit.SECONDS);
                            if (annielocked) {
                                System.out.println("t1占有了安妮");
                            }
                            else{
                                System.out.println("经过了10秒，t1放弃了占有");
                            }

                        }finally {
                            if(annielocked) {
                                System.out.println("t1释放了安妮");
                                annielock.unlock();
                            }
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
            }finally {
                    if (ahrilocked){
                        System.out.println("t1释放了九尾妖狐");
                        ahrilock.unlock();
                    }
                }
                }
        };
        t1.start();
        //确保t2慢一步，不同时释放对象
        Thread.sleep(100);
        Thread t2 = new Thread(){
            public void run(){
                boolean ahrilocked=false;
                boolean annielocked=false;

                try {
                    //试图十秒之内占有
                    annielocked=annielock.tryLock(10,TimeUnit.SECONDS);
                    if (annielocked){
                        System.out.println("t2已占有安妮");
                        //暂停1秒，给t1执行时间
                        Thread.sleep(1000);
                        System.out.println("t2试图在十秒之内占有九尾妖狐");

                        try {
                            ahrilocked=ahrilock.tryLock(10,TimeUnit.SECONDS);
                            if (ahrilocked) {
                                System.out.println("t2占有了九尾妖狐");
                            }
                            else{
                                System.out.println("经过了10秒，t2放弃了占有");
                            }

                        }finally {
                            if(ahrilocked) {
                                System.out.println("t1释放了九尾妖狐");
                                ahrilock.unlock();
                            }
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if (annielocked){
                        System.out.println("t1释放了安妮");
                        annielock.unlock();
                    }
                }
            }
        };
        t2.start();
    }
}
