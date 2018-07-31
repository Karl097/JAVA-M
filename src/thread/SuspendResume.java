package thread;

public class SuspendResume {
    public static void main(String[] args) {
        ThreadNew ob1=new ThreadNew("one");
        ThreadNew ob2=new ThreadNew("two");

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Suspending thread one");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resume thread one");
            ob2.mysuspend();
            System.out.println("Suspending thread two");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Resume thread two");
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }

        //等待线程全部结束
        try {
            System.out.println("Waiting for threads to finish");
            ob1.t.join();
            ob2.t.join();
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
