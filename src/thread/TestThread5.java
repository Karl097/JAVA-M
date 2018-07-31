package thread;
//假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击
//        就是有多个线程在减少盖伦的hp
//        同时又有多个线程在恢复盖伦的hp
//        假设线程的数量是一样的，并且每次改变的值都是1，那么所有线程结束后，盖伦应该还是10000滴血。
//        但有时会出现错误
public class TestThread5 {
    public static void main(String[] args) {

        final Hero garen=new Hero();
        garen.name="盖伦";
        garen.hp=10000;
        System.out.printf("盖伦的初始血量为%.0f\n",garen.hp);

        //多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题

        //假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击

        //用JAVA代码来表示，就是有多个线程在减少盖伦的hp
        //同时又有多个线程在恢复盖伦的hp

        //n个线程增加盖伦的hp

        int n=10000;
        Thread addThread []=new Thread[n];
        Thread reduceThread []=new Thread[n];

        //n个线程同时增加盖伦的血量

        for (int i=0;i<n;i++){
            Thread t=new Thread(){
                public void run(){
                    //在recover方法中使用synchronized修饰
                        garen.recover();
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread[i]=t;
        }

        //n个线程同时减少盖伦的血量
        for (int i=0;i<n;i++){
            Thread t=new Thread(){
                public void run(){
                    //使用garen作为synchronized
                    //在hurt方法中有synchronized(this)
                        garen.hurt();

                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThread[i]=t;
        }

        //等待所有增加线程结束
        for (Thread t:addThread){
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //等待所有减少线程结束
        for (Thread t:reduceThread){
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("n个线程增加和n个线程减少后，盖伦的血量为"+garen.hp);
    }
}
