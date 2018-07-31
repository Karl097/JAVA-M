package thread;
//比较线程优先级高低的差异
public class HiLoPri {
    public static void main(String[] args) {
        //设置主线程的优先级
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        Clicker hi=new Clicker(Thread.NORM_PRIORITY+2);
        Clicker lo=new Clicker(Thread.NORM_PRIORITY-2);

        hi.start();
        lo.start();

        //运行10秒
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        hi.stop();
        lo.stop();

        //等待线程全部结束
        try {
            hi.t.join();
            lo.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("High-Priority Thread:"+hi.click);
        System.out.println("Low-Priority Thread:"+lo.click);
    }
}
