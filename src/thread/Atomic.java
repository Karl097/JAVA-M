package thread;

import java.util.concurrent.atomic.AtomicInteger;

//分别使用基本变量的非原子性的++运算符和 原子性的AtomicInteger对象的 incrementAndGet 来进行多线程测试。
public class Atomic {
    //声明初始化
    private static int value=0;
    private static AtomicInteger atomicValue=new AtomicInteger();

    public static void main(String[] args) {
        int numbers=100000;//线程数

        //第一种使用value++;
        Thread threads1[]=new Thread[numbers];

        for (int i=0;i<numbers;i++){
            Thread t=new Thread(){
                public void run(){
                    value++;
                }
            };
            t.start();
            threads1[i]=t;
        }
        //等待线程全部结束
        for (Thread t:threads1){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行value++后，value的值变为%d\n",numbers,value);


        //第二种使用AtomicInteger
        Thread threads2[]=new Thread[numbers];

        for (int i=0;i<numbers;i++){
            Thread t=new Thread(){
                public void run(){
                    atomicValue.incrementAndGet();
                }
            };
            t.start();
            threads2[i]=t;
        }
        //等待线程全部结束
        for (Thread t:threads2){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行atomicValue.incrementAndGet()后，atomicValue的值变为%d\n",numbers,atomicValue.intValue());


    }
}
