package thread;
// Create a second thread.
public class NewThread implements Runnable{
    Thread t;
    String name;

    NewThread(String threadname){
        name=threadname;
        t=new Thread(this,name);
        System.out.println("New Thread:"+t);
        t.start();
    }

    // This is the entry point for the second thread.
    public void run(){
        try {
            for (int i=5;i>0;i--) {
                System.out.println(name+":"+i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(name+"interrupted");
        }
        System.out.println("Exiting "+name);
    }
}
