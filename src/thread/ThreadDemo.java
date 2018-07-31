package thread;

public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread("Child thread");

        try {
            for (int i=5;i>0;i--){
                System.out.println("Main thread:"+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Main thread interrupted");
        }
        System.out.println("Exiting main thread");

    }
}
