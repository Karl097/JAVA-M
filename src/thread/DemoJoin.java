package thread;

public class DemoJoin {
    public static void main(String[] args) {
        NewThread ob1=new NewThread("one");
        NewThread ob2=new NewThread("two");
        NewThread ob3=new NewThread("three");

        //判断线程是否仍在运行
        System.out.println("Thread one is alive:"+ob1.t.isAlive());
        System.out.println("Thread two is alive:"+ob2.t.isAlive());
        System.out.println("Thread three is alive:"+ob3.t.isAlive());

        //等待这些线程全部结束
        try {
            System.out.println("Waiting for threads to finish");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        //再次判断线程是否结束
        System.out.println("Thread one is alive:"+ob1.t.isAlive());
        System.out.println("Thread two is alive:"+ob2.t.isAlive());
        System.out.println("Thread three is alive:"+ob3.t.isAlive());

        System.out.println("Main thread exiting");
    }
}
