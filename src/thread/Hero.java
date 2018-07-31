package thread;

public class Hero {
    public String name;
    public float hp;
    public int damage;

    public void attackHero(Hero h){
//        //为了表示攻击需要时间，每次攻击暂停1000毫秒
//        try {
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        h.hp-=damage;
        System.out.format("%s正在攻击%s，%s的血量变成了%.0f\n",name,h.name,h.name,h.hp);

        if (h.isDead()){
            System.out.printf("%s被击杀\n",h.name);
        }

    }

    public boolean isDead(){
        return 0>=hp?true:false;
    }
//    在recover前，直接加上synchronized ，其所对应的同步对象，就是this
//            和hurt方法达到的效果是一样
//    外部线程访问gareen的方法，就不需要额外使用synchronized 了

//    在Hero类中：hurt()减血方法：当hp=1的时候，执行this.wait().
//            this.wait()表示 让占有this的线程等待，并临时释放占有
//    进入hurt方法的线程必然是减血线程，this.wait()会让减血线程临时释放对this的占有。 这样加血线程，就有机会进入recover()加血方法了。
//
//
//    recover() 加血方法：增加了血量，执行this.notify();
//this.notify() 表示通知那些等待在this的线程，可以苏醒过来了。 等待在this的线程，恰恰就是减血线程。 一旦recover()结束， 加血线程释放了this，减血线程，就可以重新占有this，并执行后面的减血工作。
    public synchronized void recover(){
        while (hp>=1000){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp+=1;
        System.out.printf("%s回血一点，当前血量是%.0f\n",name,hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第48行，等待着的减血线程，苏醒过来
        this.notify();
    }
    public synchronized void hurt(){
        while (hp<=1){
            try {
                //让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            hp -= 1;
        System.out.printf("%s减血一点，当前血量是%.0f\n",name,hp);
        this.notify();
    }
}
