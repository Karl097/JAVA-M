package thread;
// Demonstrate thread priorities.
public class Clicker implements Runnable{
    int click=0;
    Thread t;
    private volatile boolean running=true;//volatile确保每次循环running都能得到验证

    //构造方法，p设置优先级
    public Clicker(int p){
        t=new Thread(this);
        t.setPriority(p);
    }
    //
    public void run(){
        while (running){
            click++;
        }
    }
    //停止线程
    public void stop(){
        running=false;
    }
    //开始线程
    public void start(){
        t.start();
    }

}
