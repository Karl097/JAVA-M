package thread;
//使用匿名类，继承Thread,重写run方法，直接在run方法中写业务代码
//        匿名类的一个好处是可以很方便的访问外部的局部变量。
//        前提是外部的局部变量需要被声明为final。(JDK7以后就不需要了)
public class TestThread4 {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Thread thread1=new Thread(){
            public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                //但是在JDK7以后，就不是必须加final的了
                while (!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread thread2=new Thread(){
            public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                //但是在JDK7以后，就不是必须加final的了
                while (!leesin.isDead()){
                    Thread.yield();
                    bh.attackHero(leesin);
                }
            }
        };
        thread1.setPriority(5);
        thread2.setPriority(5);
        thread1.start();
        thread2.start();
    }
}
