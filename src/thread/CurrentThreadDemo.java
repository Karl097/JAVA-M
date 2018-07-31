package thread;

//控制主线程
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t=Thread.currentThread();
        //输出当前线程
        System.out.println("CurrentThread:"+t);
        //改名
        t.setName("MyThread");
        System.out.println("After changed name:"+t);

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Main thread interrupted");
        }


    }
}
