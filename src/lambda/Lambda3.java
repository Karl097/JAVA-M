package lambda;

import set.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//使用Lambda方式筛选出数据
public class Lambda3 {
    public static void main(String[] args) {
        List<Hero> heroes=new ArrayList<>();
        Random r=new Random();

        for (int i=0;i<10;i++){
            heroes.add(new Hero("hero"+i,r.nextInt(1000),r.nextInt(100)));
        }

        System.out.println("初始化完成：");
        System.out.println(heroes);
        System.out.println("使用匿名类查找筛选出 hp>100 && damage<50的英雄");
        // 匿名类的正常写法
        HeroChecker c1 = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp > 100 && h.damage < 50);
            }
        };
        // 把new HeroChcekcer，方法名，方法返回类型信息去掉
        // 只保留方法参数和方法体
        // 参数和方法体之间加上符号 ->
        HeroChecker c2 = (Hero h) -> {
            return h.hp > 100 && h.damage < 50;
        };

        // 把return和{}去掉
        HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;

        // 把 参数类型和圆括号去掉
        HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;

        // 把c4作为参数传递进去
        filter(heroes, c4);

        // 直接把表达式传递进去

        filter(heroes,h -> h.hp>100&&h.damage<50);
    }
    public static void filter(List<Hero> heroes,HeroChecker checker){
        for (Hero h:heroes){
            if (checker.test(h))
                System.out.println(h);
        }
    }
}
