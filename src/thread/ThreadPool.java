package thread;
//自定义线程池
//缓慢的给这个线程池添加任务，会看到有多条线程来执行这些任务。
//        线程7执行完毕任务后，又回到池子里，下一次任务来的时候，线程7又来执行新的任务。

import java.util.LinkedList;

public class ThreadPool {
    //线程池大小
    int threadPoolSize;

    //任务容器
    LinkedList<Runnable> tasks=new LinkedList<>();

    //试图消费任务的线程
    public ThreadPool(){
        threadPoolSize=10;

        //启动十个消费任务的线程
        synchronized (tasks){
            for (int i=0;i<threadPoolSize;i++){
                new TaskConsumerThread("任务消费者线程"+i).start();
            }
        }
    }

    public void add(Runnable r){
        synchronized (tasks){
            tasks.add(r);

            tasks.notifyAll();
        }
    }

    class TaskConsumerThread extends Thread {
        public TaskConsumerThread(String name) {
            super(name);
        }

        Runnable task;

        public void run() {
            System.out.println("启动" + this.getName());
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();

                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "获取到任务并执行");
                task.run();

            }
        }
    }
}
