package thread;
// Suspending and resuming a thread for Java2
public class ThreadNew implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    ThreadNew(String threadname){
        name=threadname;
        t=new Thread(this,"name");
        System.out.println("Thread New:"+t);
        suspendFlag=false;
        t.start();
    }

    public void run(){
        try {
            for (int i=15;i>0;i--){
                System.out.println(name+":"+i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(name+" interrupted");
        }
        System.out.println(name+"exiting");
    }

    public void mysuspend(){
        suspendFlag=true;
    }

    synchronized void myresume(){
        suspendFlag=false;
        notify();
    }
}
