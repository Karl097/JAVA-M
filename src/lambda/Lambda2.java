package lambda;

import set.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//首先准备一个接口HeroChecker，提供一个test(Hero)方法
//        然后通过匿名类的方式，实现这个接口
//
//        HeroChecker checker = new HeroChecker() {
//public boolean test(Hero h) {
//        return (h.hp>100 && h.damage<50);
//        }
//        };
//        接着调用filter，传递这个checker进去进行判断
public class Lambda2 {
    public static void main(String[] args) {
        List<Hero> heroes=new ArrayList<>();
        Random r=new Random();

        for (int i=0;i<10;i++){
            heroes.add(new Hero("hero"+i,r.nextInt(1000),r.nextInt(100)));
        }

        System.out.println("初始化完成：");
        System.out.println(heroes);
        System.out.println("使用匿名类查找筛选出 hp>100 && damage<50的英雄");

        HeroChecker checker=new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp>100&&h.damage<50);
            }
        };

        filter(heroes,checker);
    }
    public static void filter(List<Hero> heroes,HeroChecker checker){
        for (Hero h:heroes){
            if (checker.test(h))
                System.out.println(h);
        }
    }
}
