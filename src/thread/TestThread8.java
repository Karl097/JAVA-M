package thread;
//让盖伦同时进行减血和加血，减血频率更快
public class TestThread8 {
    public static void main(String[] args) {
        Hero garen=new Hero();
        garen.name="盖伦";
        garen.hp=616;

        //减血线程
        Thread t1=new Thread(){
            public  void run(){
                while (garen.hp==1) {
                    continue;
                }
                    while (true) {
                        garen.hurt();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

            }
        };
        t1.start();

        Thread t2=new Thread(){
            public void run(){
                while (true){
                    garen.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();

    }
}
