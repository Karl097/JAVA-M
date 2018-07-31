package thread;

import jdk.dynalink.beans.StaticClass;

//假设加血线程运行得更加频繁，英雄的最大血量是1000
//
//        设计加血线程和减血线程的交互，让回血回满之后，加血线程等待，直到有减血线程减血
public class ThreadExercise5 {
        //减血线程
        static class HurtThread extends Thread{
            private Hero hero;
            public HurtThread(Hero hero){
                this.hero=hero;
            }
            public  void run(){
                while (true) {
                    hero.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        static  class RecoverThread extends Thread {
            private Hero hero;

            public RecoverThread(Hero hero) {
                this.hero = hero;
            }

            public void run() {
                while (true) {
                    hero.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    public static void main(String[] args) {


        final Hero garen = new Hero();
        garen.name = "盖伦";
        garen.hp = 616;

        for (int i=0;i<2;i++){
            new RecoverThread(garen).start();
        }

        for (int i=0;i<5;i++){
            new HurtThread(garen).start();
        }
    }
}

