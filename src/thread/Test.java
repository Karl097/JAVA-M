package thread;

public class Test {
    public static void main(String[] args) {
        Thread t=new Thread(){
            public void run() {
                int seconds = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL%d秒\n",seconds++);
                }
            }
        };
        t.setDaemon(true);
        t.start();
    }
}
